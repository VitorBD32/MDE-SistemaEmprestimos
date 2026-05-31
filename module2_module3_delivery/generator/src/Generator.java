import java.io.*;
import java.nio.file.*;
import java.time.LocalDateTime;
import java.util.*;
import javax.xml.parsers.*;
import org.w3c.dom.*;

public class Generator {

    static class Professor {
        String nome;
        String matricula;
        String departamento;
    }

    static class Equipamento {
        String nome;
        String codigo;
        boolean isDisponivel;
    }

    static class Emprestimo {
        LocalDateTime dataRetirada;
        LocalDateTime dataDevolucaoPrevista;
        String equipamentoCodigo;
        String professorMatricula;
    }

    public static void main(String[] args) throws Exception {
        Path base = Paths.get("instances");
        if (!Files.exists(base)) {
            System.err.println("Diretório 'instances' não encontrado. Execute a partir de module2_module3_delivery/generator");
            return;
        }

        Map<String, Professor> professors = new HashMap<>();
        Map<String, Equipamento> equipments = new HashMap<>();
        List<Emprestimo> emprestimos = new ArrayList<>();

        // parse each XMI file
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        dbf.setNamespaceAware(true);
        DocumentBuilder db = dbf.newDocumentBuilder();

        // read files
        try (DirectoryStream<Path> ds = Files.newDirectoryStream(base, "*.xmi")) {
            for (Path p : ds) {
                Document doc = db.parse(p.toFile());
                Element root = doc.getDocumentElement();
                String localName = root.getLocalName();
                if ("Professor".equals(localName)) {
                    Professor prof = new Professor();
                    prof.nome = root.getAttribute("nome");
                    prof.matricula = root.getAttribute("matricula");
                    prof.departamento = root.getAttribute("departamento");
                    if (prof.matricula == null || prof.matricula.isEmpty()) {
                        System.out.println("Aviso: professor sem matricula em " + p);
                    }
                    // unique matricula check
                    if (professors.containsKey(prof.matricula)) {
                        System.err.println("Erro: matricula duplicada encontrada: " + prof.matricula + " (" + p + ")");
                    }
                    professors.put(prof.matricula, prof);
                } else if ("Equipamento".equals(localName)) {
                    Equipamento eq = new Equipamento();
                    eq.nome = root.getAttribute("nome");
                    eq.codigo = root.getAttribute("codigoTombamento");
                    String avail = root.getAttribute("isDisponivel");
                    eq.isDisponivel = "true".equalsIgnoreCase(avail) || "1".equals(avail);
                    equipments.put(eq.codigo, eq);
                } else if ("Emprestimo".equals(localName)) {
                    Emprestimo em = new Emprestimo();
                    String dr = root.getAttribute("dataRetirada");
                    String dp = root.getAttribute("dataDevolucaoPrevista");
                    if (dr != null && !dr.isEmpty()) em.dataRetirada = LocalDateTime.parse(dr);
                    if (dp != null && !dp.isEmpty()) em.dataDevolucaoPrevista = LocalDateTime.parse(dp);
                    em.equipamentoCodigo = root.getAttribute("equipamentoCodigo");
                    em.professorMatricula = root.getAttribute("professorMatricula");
                    emprestimos.add(em);
                } else {
                    System.out.println("Arquivo XMI com root desconhecido: " + p + " -> " + localName);
                }
            }
        }

        System.out.println("Professores lidos: " + professors.size());
        System.out.println("Equipamentos lidos: " + equipments.size());
        System.out.println("Emprestimos lidos: " + emprestimos.size());

        // validate OCL-equivalent rules
        boolean ok = true;

        // 1) matricula unica (already checked on insert, but double-check)
        Set<String> seen = new HashSet<>();
        for (Professor p : professors.values()) {
            if (p.matricula != null && !p.matricula.isEmpty()) {
                if (!seen.add(p.matricula)) {
                    System.err.println("Violação OCL: matricula não é única -> " + p.matricula);
                    ok = false;
                }
            }
        }

        // 2) para cada emprestimo, equipamentoDisponivel
        for (Emprestimo e : emprestimos) {
            if (e.equipamentoCodigo != null && !e.equipamentoCodigo.isEmpty()) {
                Equipamento eq = equipments.get(e.equipamentoCodigo);
                if (eq == null) {
                    System.err.println("Violação: emprestimo referencia equipamento desconhecido: " + e.equipamentoCodigo);
                    ok = false;
                } else if (!eq.isDisponivel) {
                    System.err.println("Violação OCL: equipamento não disponível para emprestimo: " + eq.codigo);
                    ok = false;
                }
            }
            // 3) data devolução >= data retirada
            if (e.dataRetirada != null && e.dataDevolucaoPrevista != null) {
                if (e.dataDevolucaoPrevista.isBefore(e.dataRetirada)) {
                    System.err.println("Violação OCL: dataDevolucaoPrevista antes de dataRetirada para emprestimo de prof " + e.professorMatricula);
                    ok = false;
                }
            }
        }

        if (ok) System.out.println("Validação: todas as regras OCL equivalentes passaram.");
        else System.out.println("Validação: foram encontradas violações. Veja mensagens acima.");

        // M2M: construir PSM simples (modelo JSON)
        Path outDir = Paths.get("output");
        if (!Files.exists(outDir)) Files.createDirectories(outDir);

        StringBuilder json = new StringBuilder();
        json.append("{\n  \"tables\": [\n");

        // Professor table
        json.append("    {\n      \"name\": \"Professor\",\n      \"columns\": [\n");
        json.append("        {\"name\": \"matricula\", \"type\": \"VARCHAR(64)\", \"pk\": true},\n");
        json.append("        {\"name\": \"nome\", \"type\": \"VARCHAR(255)\"},\n");
        json.append("        {\"name\": \"departamento\", \"type\": \"VARCHAR(128)\"}\n");
        json.append("      ]\n    },\n");

        // Equipamento table
        json.append("    {\n      \"name\": \"Equipamento\",\n      \"columns\": [\n");
        json.append("        {\"name\": \"codigoTombamento\", \"type\": \"INT\", \"pk\": true},\n");
        json.append("        {\"name\": \"nome\", \"type\": \"VARCHAR(255)\"},\n");
        json.append("        {\"name\": \"isDisponivel\", \"type\": \"BOOLEAN\"}\n");
        json.append("      ]\n    },\n");

        // Emprestimo table
        json.append("    {\n      \"name\": \"Emprestimo\",\n      \"columns\": [\n");
        json.append("        {\"name\": \"id\", \"type\": \"INTEGER\", \"pk\": true},\n");
        json.append("        {\"name\": \"dataRetirada\", \"type\": \"TIMESTAMP\"},\n");
        json.append("        {\"name\": \"dataDevolucaoPrevista\", \"type\": \"TIMESTAMP\"},\n");
        json.append("        {\"name\": \"equipamentoCodigo\", \"type\": \"INT\"},\n");
        json.append("        {\"name\": \"professorMatricula\", \"type\": \"VARCHAR(64)\"}\n");
        json.append("      ]\n    }\n");

        json.append("  ]\n}\n");

        Files.write(outDir.resolve("psm_model.json"), json.toString().getBytes());
        System.out.println("PSM (psm_model.json) gerado em: output/psm_model.json");

        // M2T: gerar SQL DDL
        StringBuilder sql = new StringBuilder();
        sql.append("-- SQL gerado automaticamente\n\n");

        sql.append("CREATE TABLE Professor (\n  matricula VARCHAR(64) PRIMARY KEY,\n  nome VARCHAR(255),\n  departamento VARCHAR(128)\n);\n\n");

        sql.append("CREATE TABLE Equipamento (\n  codigoTombamento INT PRIMARY KEY,\n  nome VARCHAR(255),\n  isDisponivel BOOLEAN\n);\n\n");

        sql.append("CREATE TABLE Emprestimo (\n  id INTEGER PRIMARY KEY AUTOINCREMENT,\n  dataRetirada TIMESTAMP,\n  dataDevolucaoPrevista TIMESTAMP,\n  equipamentoCodigo INT,\n  professorMatricula VARCHAR(64),\n  FOREIGN KEY (equipamentoCodigo) REFERENCES Equipamento(codigoTombamento),\n  FOREIGN KEY (professorMatricula) REFERENCES Professor(matricula)\n);\n");

        Files.write(outDir.resolve("create_tables.sql"), sql.toString().getBytes());
        System.out.println("SQL gerado em: output/create_tables.sql");
    }
}
