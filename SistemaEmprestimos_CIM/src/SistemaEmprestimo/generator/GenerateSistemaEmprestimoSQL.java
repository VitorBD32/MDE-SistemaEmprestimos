/*******************************************************************************
 * Copyright (c) 2026 - Sistema de Empréstimos MDE
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Vitor BD32 - initial API and implementation
 *******************************************************************************/
package SistemaEmprestimo.generator;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.acceleo.engine.event.IAcceleoTextGenerationListener;
import org.eclipse.acceleo.engine.generation.strategy.IAcceleoGenerationStrategy;
import org.eclipse.acceleo.engine.service.AbstractAcceleoGenerator;
import org.eclipse.emf.common.util.BasicMonitor;
import org.eclipse.emf.common.util.Monitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;

/**
 * Entry point of the 'GenerateSistemaEmprestimoSQL' generation module.
 * 
 * Este gerador M2T (Model-to-Text) utiliza a template Acceleo para converter
 * o modelo Relacional (PSM - Platform Specific Model) em um script SQL DDL.
 * 
 * Fluxo completo:
 * 1. CIM (My.ecore) -> [ATL - M2MM] -> PSM Relacional (Relational.ecore)
 * 2. PSM Relacional -> [Acceleo - M2T] -> Script SQL (schema_sistema_emprestimos.sql)
 *
 * @generated NOT
 * @author Vitor BD32
 * @version 1.0
 */
public class GenerateSistemaEmprestimoSQL extends AbstractAcceleoGenerator {
    
    /**
     * The name of the module.
     *
     * @generated
     */
    public static final String MODULE_FILE_NAME = "/SistemaEmprestimo/generator/GenerateSistemaEmprestimoSQL";
    
    /**
     * The name of the templates that are to be generated.
     *
     * @generated
     */
    public static final String[] TEMPLATE_NAMES = { "main" };
    
    /**
     * The list of properties files from the launch parameters (Launch configuration).
     *
     * @generated
     */
    private List<String> propertiesFiles = new ArrayList<String>();

    /**
     * Allows the public constructor to be used. Note that a generator created
     * this way cannot be used to launch generations before one of
     * {@link #initialize(EObject, File, List)} or
     * {@link #initialize(URI, File, List)} is called.
     * <p>
     * The main reason for this constructor is to allow clients of this
     * generation to call it from another Java file, as it allows for the
     * retrieval of {@link #getProperties()} and
     * {@link #getGenerationListeners()}.
     * </p>
     *
     * @generated
     */
    public GenerateSistemaEmprestimoSQL() {
        // Empty implementation
    }

    /**
     * This allows clients to instantiates a generator with all required information.
     * 
     * @param modelURI
     *            URI where the model on which this generator will be used is located.
     * @param targetFolder
     *            This will be used as the output folder for this generation : it will be the base path
     *            against which all file block URLs will be resolved.
     * @param arguments
     *            If the template which will be called requires more than one argument taken from the model,
     *            pass them here.
     * @throws IOException
     *             This can be thrown in three scenarios : the module cannot be found, it cannot be loaded, or
     *             the model cannot be loaded.
     * @generated
     */
    public GenerateSistemaEmprestimoSQL(URI modelURI, File targetFolder,
            List<? extends Object> arguments) throws IOException {
        initialize(modelURI, targetFolder, arguments);
    }

    /**
     * This allows clients to instantiates a generator with all required information.
     * 
     * @param model
     *            We'll iterate over the content of this element to find Objects matching the first parameter
     *            of the template we need to call.
     * @param targetFolder
     *            This will be used as the output folder for this generation : it will be the base path
     *            against which all file block URLs will be resolved.
     * @param arguments
     *            If the template which will be called requires more than one argument taken from the model,
     *            pass them here.
     * @throws IOException
     *             This can be thrown in two scenarios : the module cannot be found, or it cannot be loaded.
     * @generated
     */
    public GenerateSistemaEmprestimoSQL(EObject model, File targetFolder,
            List<? extends Object> arguments) throws IOException {
        initialize(model, targetFolder, arguments);
    }
    
    /**
     * This can be used to launch the generation from a standalone application.
     * 
     * Uso:
     *   java GenerateSistemaEmprestimoSQL <model_path> <output_folder> [properties_files...]
     * 
     * Exemplo:
     *   java GenerateSistemaEmprestimoSQL psm_relational.xmi ./output_sql
     * 
     * @param args
     *            Arguments of the generation: model_path, output_folder, optional_properties_files
     * @generated NOT
     */
    public static void main(String[] args) {
        try {
            if (args.length < 2) {
                System.err.println("Erro: argumentos insuficientes.");
                System.err.println("Uso: java GenerateSistemaEmprestimoSQL <model> <folder> [properties...]");
                System.err.println("Exemplo: java GenerateSistemaEmprestimoSQL psm_relational.xmi ./output_sql");
                System.exit(1);
            } else {
                URI modelURI = URI.createFileURI(args[0]);
                File folder = new File(args[1]);
                
                // Validar se o arquivo de modelo existe
                File modelFile = new File(args[0]);
                if (!modelFile.exists()) {
                    System.err.println("Erro: arquivo de modelo não encontrado: " + args[0]);
                    System.exit(1);
                }
                
                // Criar pasta de saída se não existir
                if (!folder.exists()) {
                    folder.mkdirs();
                    System.out.println("Pasta de saída criada: " + folder.getAbsolutePath());
                }
                
                List<String> arguments = new ArrayList<String>();
                
                System.out.println("======================================================");
                System.out.println("  M2T - Gerador SQL do Sistema de Empréstimos");
                System.out.println("======================================================");
                System.out.println("Modelo de entrada: " + modelURI);
                System.out.println("Pasta de saída: " + folder.getAbsolutePath());
                
                GenerateSistemaEmprestimoSQL generator = new GenerateSistemaEmprestimoSQL(modelURI, folder, arguments);
                
                // Adicionar arquivos de propriedades (se fornecidos)
                for (int i = 2; i < args.length; i++) {
                    generator.addPropertiesFile(args[i]);
                    System.out.println("Propriedades carregadas: " + args[i]);
                }
                
                System.out.println("Iniciando geração...");
                generator.doGenerate(new BasicMonitor());
                System.out.println("✓ Geração concluída com sucesso!");
                System.out.println("======================================================");
            }
        } catch (IOException e) {
            System.err.println("Erro na geração SQL:");
            e.printStackTrace();
            System.exit(1);
        }
    }

    /**
     * Launches the generation described by this instance.
     * 
     * @param monitor
     *            This will be used to display progress information to the user.
     * @throws IOException
     *             This will be thrown if any of the output files cannot be saved to disk.
     * @generated
     */
    @Override
    public void doGenerate(Monitor monitor) throws IOException {
        /*
         * Verifica integridade dos modelos e resolve proxies não resolvidos
         * Comentar linhas abaixo se tiver problemas de performance
         */
        // org.eclipse.emf.ecore.util.EcoreUtil.resolveAll(model);

        /*
         * Verifica potenciais erros no modelo antes de iniciar a geração
         */
        if (model != null && model.eResource() != null) {
            List<org.eclipse.emf.ecore.resource.Resource.Diagnostic> errors = model.eResource().getErrors();
            if (!errors.isEmpty()) {
                System.out.println("Avisos de carregamento do modelo:");
                for (org.eclipse.emf.ecore.resource.Resource.Diagnostic diagnostic : errors) {
                    System.out.println("  " + diagnostic.toString());
                }
            }
        }

        super.doGenerate(monitor);
    }
    
    /**
     * If this generator needs to listen to text generation events, listeners can be returned from here.
     * 
     * @return List of listeners that are to be notified when text is generated through this launch.
     * @generated
     */
    @Override
    public List<IAcceleoTextGenerationListener> getGenerationListeners() {
        List<IAcceleoTextGenerationListener> listeners = super.getGenerationListeners();
        /*
         * TODO if you need to listen to generation event, add listeners to the list here.
         */
        return listeners;
    }
    
    /**
     * If you need to change the way files are generated, this is your entry point.
     * <p>
     * The default is {@link org.eclipse.acceleo.engine.generation.strategy.DefaultStrategy}; it generates
     * files on the fly. If you only need to preview the results, return a new
     * {@link org.eclipse.acceleo.engine.generation.strategy.PreviewStrategy}. Both of these aren't aware of
     * the running Eclipse and can be used standalone.
     * </p>
     * 
     * @return The generation strategy that is to be used for generations launched through this launcher.
     * @generated
     */
    @Override
    public IAcceleoGenerationStrategy getGenerationStrategy() {
        return super.getGenerationStrategy();
    }
    
    /**
     * This will be called in order to find and load the module that will be launched through this launcher.
     * We expect this name not to contain file extension, and the module to be located beside the launcher.
     * 
     * @return The name of the module that is to be launched.
     * @generated
     */
    @Override
    public String getModuleName() {
        return MODULE_FILE_NAME;
    }
    
    /**
     * If the module(s) called by this launcher require properties files, return their qualified path from
     * here.Take note that the first added properties files will take precedence over subsequent ones if they
     * contain conflicting keys.
     * 
     * @return The list of properties file we need to add to the generation context.
     * @see java.util.ResourceBundle#getBundle(String)
     * @generated
     */
    @Override
    public List<String> getProperties() {
        return propertiesFiles;
    }
    
    /**
     * Adds a properties file in the list of properties files.
     * 
     * @param propertiesFile
     *            The properties file to add.
     * @generated
     * @since 3.1
     */
    @Override
    public void addPropertiesFile(String propertiesFile) {
        this.propertiesFiles.add(propertiesFile);
    }
    
    /**
     * This will be used to get the list of templates that are to be launched by this launcher.
     * 
     * @return The list of templates to call on the module {@link #getModuleName()}.
     * @generated
     */
    @Override
    public String[] getTemplateNames() {
        return TEMPLATE_NAMES;
    }
    
    /**
     * This can be used to update the resource set's package registry with all needed EPackages.
     * 
     * @param resourceSet
     *            The resource set which registry has to be updated.
     * @generated
     */
    @Override
    public void registerPackages(ResourceSet resourceSet) {
        super.registerPackages(resourceSet);
        /*
         * Registra o metamodelo Relational (PSM)
         */
        // Registro automático via EMF quando o metamodelo está no workspace
    }

    /**
     * This can be used to update the resource set's resource factory registry with all needed factories.
     * 
     * @param resourceSet
     *            The resource set which registry has to be updated.
     * @generated
     */
    @Override
    public void registerResourceFactories(ResourceSet resourceSet) {
        super.registerResourceFactories(resourceSet);
        /*
         * Factories adicionais podem ser registradas aqui se necessário
         */
    }
}
