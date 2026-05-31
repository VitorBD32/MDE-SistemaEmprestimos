package tools;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.ocl.ParserException;
import org.eclipse.ocl.ecore.OCL;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.OCL.Helper;

/**
 * Headless OCL validator: loads My.ecore and model instances (XMI) and validates constraints
 * declared in a simple `constraints.ocl` file (format: context <pkg>::<Class> inv <name>: <expression>)
 *
 * Run this class as a Java Application inside Eclipse (the project must have EMF and OCL on the classpath).
 */
public class HeadlessOCLValidator {

    static class ConstraintSpec {
        String contextQualified;
        String contextSimple;
        String name;
        String expression;
    }

    public static void main(String[] args) throws Exception {
        // paths (relative to project root)
        String projectRoot = new File(".").getCanonicalPath();
        String ecorePath = projectRoot + File.separator + "module2_module3_delivery" + File.separator + "My.ecore";
        String instancesDir = projectRoot + File.separator + "module2_module3_delivery" + File.separator + "instances";
        String constraintsPath = projectRoot + File.separator + "module2_module3_delivery" + File.separator + "constraints.ocl";

        System.out.println("Headless OCL Validator");
        System.out.println("Project root: " + projectRoot);

        // parse constraints file
        List<ConstraintSpec> specs = parseConstraints(constraintsPath);
        System.out.println("Constraints parsed: " + specs.size());

        // setup EMF resource set
        ResourceSet rs = new ResourceSetImpl();
        rs.getResourceFactoryRegistry().getExtensionToFactoryMap().put("ecore", new EcoreResourceFactoryImpl());
        rs.getResourceFactoryRegistry().getExtensionToFactoryMap().put("xmi", new XMIResourceFactoryImpl());
        rs.getResourceFactoryRegistry().getExtensionToFactoryMap().put("*", new XMIResourceFactoryImpl());

        // load ecore
        Resource ecoreRes = rs.getResource(URI.createFileURI(ecorePath), true);
        if (ecoreRes.getContents().isEmpty()) {
            System.err.println("Failed to load Ecore: " + ecorePath);
            System.exit(2);
        }
        EPackage pkg = (EPackage) ecoreRes.getContents().get(0);
        EPackage.Registry.INSTANCE.put(pkg.getNsURI(), pkg);
        System.out.println("Loaded Ecore: " + pkg.getName() + " nsURI=" + pkg.getNsURI());

        // load instances
        File instDir = new File(instancesDir);
        if (!instDir.exists() || !instDir.isDirectory()) {
            System.err.println("Instances directory not found: " + instancesDir);
            System.exit(3);
        }

        List<Resource> modelResources = new ArrayList<>();
        for (File f : instDir.listFiles((d, name) -> name.endsWith(".xmi"))) {
            System.out.println("Loading instance: " + f.getName());
            Resource r = rs.getResource(URI.createFileURI(f.getAbsolutePath()), true);
            modelResources.add(r);
        }

        // prepare OCL
        OCL ocl = OCL.newInstance(org.eclipse.ocl.ecore.EcoreEnvironmentFactory.INSTANCE);
        Helper helper = ocl.createOCLHelper();

        boolean allOk = true;

        // for each constraint create invariant and evaluate on all instances of the context
        for (ConstraintSpec cs : specs) {
            String[] parts = cs.contextQualified.split("::");
            String simple = parts[parts.length - 1];
            cs.contextSimple = simple;
            EClassifier ecl = pkg.getEClassifier(simple);
            if (ecl == null || !(ecl instanceof EClass)) {
                System.err.println("Context class not found in Ecore: " + cs.contextQualified);
                allOk = false;
                continue;
            }
            EClass context = (EClass) ecl;
            helper.setContext(context);
            try {
                Constraint inv = helper.createInvariant(cs.expression);

                // iterate over all loaded resources and find instances
                for (Resource mr : modelResources) {
                    TreeIterator<EObject> tit = mr.getAllContents();
                    while (tit.hasNext()) {
                        EObject obj = tit.next();
                        if (obj.eClass() == context) {
                            boolean valid = ocl.check(obj, inv);
                            if (!valid) {
                                System.err.println("OCL Violation [" + cs.name + "] on instance of " + cs.contextSimple + " -> " + obj);
                                allOk = false;
                            }
                        }
                    }
                }

            } catch (ParserException pe) {
                System.err.println("Failed to parse OCL expression for constraint " + cs.name + ": " + pe.getMessage());
                allOk = false;
            }
        }

        if (allOk) {
            System.out.println("Validation OK: todas as restrições passaram.");
            System.exit(0);
        } else {
            System.err.println("Validation FAILED: existiram violações.");
            System.exit(4);
        }
    }

    private static List<ConstraintSpec> parseConstraints(String constraintsPath) throws Exception {
        List<ConstraintSpec> list = new ArrayList<>();
        File f = new File(constraintsPath);
        if (!f.exists()) return list;
        BufferedReader br = new BufferedReader(new FileReader(f));
        String line;
        ConstraintSpec current = null;
        while ((line = br.readLine()) != null) {
            line = line.trim();
            if (line.isEmpty() || line.startsWith("--")) continue;
            if (line.startsWith("context ")) {
                // example: context sistema_emprestimo::Professor inv matriculaUnica:
                int invIdx = line.indexOf(" inv ");
                int colonIdx = line.indexOf(":", invIdx);
                if (invIdx > 0 && colonIdx > invIdx) {
                    String ctx = line.substring(8, invIdx).trim();
                    String name = line.substring(invIdx + 5, colonIdx).trim();
                    current = new ConstraintSpec();
                    current.contextQualified = ctx;
                    current.name = name;
                    // read next non-empty line as expression
                    String expr = br.readLine();
                    if (expr != null) current.expression = expr.trim();
                    list.add(current);
                    current = null;
                }
            }
        }
        br.close();
        return list;
    }
}
