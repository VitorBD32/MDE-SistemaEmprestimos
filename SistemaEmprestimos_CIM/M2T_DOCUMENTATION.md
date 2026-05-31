# 📊 M2T (Model-to-Text) — Sistema de Empréstimos MDE

> Documentação completa da transformação **Model-to-Text** do projeto Sistema de Empréstimos, parte do pipeline MDE (Model-Driven Engineering).

---

## 📑 Índice

1. [Visão Geral](#visão-geral)
2. [Arquitetura M2T](#arquitetura-m2t)
3. [Pipeline Completo de Transformações](#pipeline-completo)
4. [Componentes M2T](#componentes-m2t)
5. [Como Usar](#como-usar)
6. [Exemplos](#exemplos)
7. [Troubleshooting](#troubleshooting)

---

## 🎯 Visão Geral

### O que é M2T?

**M2T (Model-to-Text)** é a última etapa do pipeline MDE onde modelos são transformados em código-fonte, scripts ou arquivos de configuração para consumo por sistemas reais.

No Sistema de Empréstimos, implementamos:
- **Entrada (PSM)**: Modelo Relacional (Relational.ecore) em XMI
- **Processo**: Template Acceleo (GenerateSQL.mtl)
- **Saída (Código)**: Scripts SQL DDL para banco de dados

### Por que M2T é Importante?

```
┌─────────────────────────────────────────────────────────────┐
│                    Processo MDE Completo                    │
├─────────────────────────────────────────────────────────────┤
│                                                              │
│  CIM (My.ecore)                   Modelos Conceituais      │
│        ↓                                                     │
│     [M2MM via ATL]         Mapeamento Estrutural            │
│        ↓                                                     │
│  PSM Relacional          Modelos Específicos de Plataforma │
│        ↓                                                     │
│     [M2T via Acceleo] ← ← → ← Geração de Artefatos ← ← →  │
│        ↓                                                     │
│  Scripts SQL / Código    Código Executável                 │
│  Java / Configurações                                       │
│                                                              │
└─────────────────────────────────────────────────────────────┘
```

---

## 🏛️ Arquitetura M2T

### Componentes Principais

#### 1. **Template Acceleo** (`GenerateSQL.mtl`)

Arquivo de template em linguagem **Acceleo** (sintaxe orientada a templates):

```
Localização: SistemaEmprestimos_CIM/emf_atl/GenerateSQL.mtl
Linguagem:   Acceleo 3.x (baseado em MTL - MOF 2.0 Template Language)
Função:      Converter modelo Relacional em SQL DDL
```

**Características da Template:**

- **Query OCL**: Consultas para navegar e acessar dados do modelo
- **Loops**: Iteração sobre coleções do modelo
- **Condicionais**: Lógica para gerar diferentes estruturas SQL
- **Filters**: Seleção de elementos conforme critérios

#### 2. **Classe Java Geradora** (`GenerateSistemaEmprestimoSQL.java`)

Classe que executa a template Acceleo programaticamente:

```
Localização: SistemaEmprestimos_CIM/src/SistemaEmprestimo/generator/
Classe:      GenerateSistemaEmprestimoSQL.java
Estende:     AbstractAcceleoGenerator (framework Acceleo)
```

**Responsabilidades:**

- Carregar o modelo PSM (XMI)
- Registrar metamodelos no ResourceSet
- Executar a template Acceleo
- Salvar arquivos gerados no disco

#### 3. **Configuração de Execução** (`acceleo_generate.launch`)

Arquivo Eclipse Launch configuration que configura a execução da geração:

```xml
<launchConfiguration type="org.eclipse.acceleo.engine.ui.launching.AcceleoLauncher">
  <stringAttribute key="modulePath" value="/SistemaEmprestimos_CIM/emf_atl/GenerateSQL.mtl"/>
  <stringAttribute key="modelURI" value="...psm_relational_sample.xmi"/>
  <stringAttribute key="metamodelURI" value="...Relational.ecore"/>
  <stringAttribute key="targetFolder" value=".../output_sql"/>
</launchConfiguration>
```

---

## 🔄 Pipeline Completo

### Fluxo Integrado (CIM → PIM → PSM → Código)

```
1. ENTRADA: Metamodelo CIM
   └─ Arquivo: My.ecore (metamodelo conceitual)
   └─ Contém: EClass Professor, Equipamento, Emprestimo

2. VALIDAÇÃO OCL
   └─ Arquivo: constraints.ocl
   └─ Ferramenta: HeadlessOCLValidator
   └─ Resultado: ✓ Modelo válido ou ✗ Violações

3. M2MM VIA ATL (Model-to-Model)
   ├─ Transformação 1: ecore2relational.atl
   │  └─ Entrada: My.ecore (metamodelo)
   │  └─ Saída: modelo Relational em XMI
   │
   └─ Transformação 2: sistema2relational.atl
      └─ Entrada: instâncias XMI (Professor.xmi, etc)
      └─ Saída: PSM Relational com esquema de tabelas

4. M2T VIA ACCELEO (Model-to-Text)
   ├─ Template: GenerateSQL.mtl
   ├─ Entrada: psm_relational.xmi (PSM)
   ├─ Processamento:
   │  ├─ Iterar tabelas do modelo
   │  ├─ Para cada tabela, gerar CREATE TABLE
   │  ├─ Adicionar constraints (PK, FK)
   │  └─ Gerar índices para otimização
   └─ Saída: schema_sistema_emprestimos.sql

5. ARTEFATO FINAL
   └─ Arquivo: schema_sistema_emprestimos.sql
   └─ Tipo: Script SQL DDL executável
   └─ Uso: Importar em banco de dados (MySQL, PostgreSQL, etc)
```

---

## 🧩 Componentes M2T

### 1. GenerateSQL.mtl (Template Acceleo)

**Estrutura:**

```acceleo
[module generate('relational')]    // Declaração do módulo
                                    // 'relational' = metamodelo alvo

[template public main(...)]         // Template principal (entry point)
  // Código Acceleo que gera SQL
[/template]

[template public generateTableDDL(...)]  // Template auxiliar
  // Gera CREATE TABLE para uma tabela
[/template]

[query public getPrimaryKey(...)]   // Query OCL para consultar
  // Retorna chave primária
[/query]
```

**Sintaxe Acceleo:**

| Elemento | Sintaxe | Exemplo |
|----------|--------|---------|
| Template | `[template public name(params)]` | `[template public main(t : Table)]` |
| Comentário | `[comment text /]` | `[comment Gera SQL /]` |
| Variável | `[var/]` | `[table.name/]` |
| Loop | `[for (item \| collection)]` | `[for (col \| table.columns)]` |
| Condicional | `[if (condition)]` | `[if (col.pk)]PRIMARY KEY[/if]` |
| Query OCL | `[query public name(...)]` | `[query public getPrimaryKey(...)]` |
| Separador | `[collection->sep(', ')]` | `[cols->sep(', ')]` |

### 2. GenerateSistemaEmprestimoSQL.java

**Métodos Principais:**

```java
// Construtor parametrizado
public GenerateSistemaEmprestimoSQL(URI modelURI, File targetFolder, 
                                    List<? extends Object> arguments)
  // URI do modelo PSM a carregar
  // Pasta de saída para artefatos gerados
  // Argumentos adicionais

// Ponto de entrada standalone
public static void main(String[] args)
  // args[0] = caminho para psm_relational.xmi
  // args[1] = pasta de saída

// Executa a geração
public void doGenerate(Monitor monitor) throws IOException
  // Inicia o processo de geração
  // Monitora progresso

// Registra metamodelos
protected void registerPackages(ResourceSet resourceSet)
  // Carrega Relational.ecore no registry
```

**Uso Standalone (Linha de Comando):**

```bash
java -cp .../plugins/*: SistemaEmprestimo.generator.GenerateSistemaEmprestimoSQL \
  psm_relational.xmi \
  ./output_sql
```

### 3. Arquivos de Entrada (PSM)

**psm_relational_sample.xmi** — Exemplo de PSM:

```xml
<?xml version="1.0" encoding="UTF-8"?>
<relational:Relational xmi:version="2.0" 
  xmlns:xmi="http://www.omg.org/XMI"
  xmlns:relational="http://exemplo.com/relational">
  
  <table name="Professor">
    <columns name="matricula" type="VARCHAR(64)" pk="true"/>
    <columns name="nome" type="VARCHAR(255)" pk="false"/>
  </table>
  
  <!-- ... mais tabelas ... -->
</relational:Relational>
```

---

## 🚀 Como Usar

### Opção 1: Executar via Eclipse GUI

**Passos:**

1. Abra o Eclipse IDE com o projeto importado
2. Clique direito em `acceleo_generate.launch`
3. Selecione `Run As → Acceleo Application`
4. Arquivos serão gerados em `SistemaEmprestimos_CIM/output_sql/`

**Resultado esperado:**

```
✓ Acceleo file generation finished
Generated files:
  - output_sql/schema.sql
  - output_sql/tables.sql
  - ... outros arquivos ...
```

### Opção 2: Executar Launch Group (Fluxo Completo)

**Passos:**

1. Abra `run_all.launch` no Project Explorer
2. Clique direito → `Run As → Launch Group`
3. Serão executadas em sequência:
   - ✓ Validação OCL (`headless_ocl_validator.launch`)
   - ✓ M2MM ATL (`ecore2relational.launch`)
   - ✓ M2T Acceleo (`acceleo_generate.launch`)

### Opção 3: Executar Programaticamente (Java)

```java
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.emf.common.util.URI;

// Configurar entrada e saída
URI modelURI = URI.createFileURI("psm_relational.xmi");
File outputFolder = new File("./output_sql");
List<String> arguments = new ArrayList<>();

// Criar gerador e executar
GenerateSistemaEmprestimoSQL generator = 
  new GenerateSistemaEmprestimoSQL(modelURI, outputFolder, arguments);

generator.doGenerate(new BasicMonitor());
```

### Opção 4: Executar via Linha de Comando

```bash
# Navegar até o diretório do projeto
cd SistemaEmprestimos_CIM

# Compilar (se necessário)
javac -cp ".../plugins/*" \
  src/SistemaEmprestimo/generator/GenerateSistemaEmprestimoSQL.java

# Executar
java -cp ".../plugins/*:bin" \
  SistemaEmprestimo.generator.GenerateSistemaEmprestimoSQL \
  emf_atl/psm_relational_sample.xmi \
  ./output_sql
```

---

## 💡 Exemplos

### Exemplo 1: Template Simples

**Entrada (PSM em XMI):**
```xml
<Table name="Professor">
  <columns name="matricula" type="VARCHAR(64)" pk="true"/>
  <columns name="nome" type="VARCHAR(255)"/>
</Table>
```

**Template Acceleo:**
```acceleo
[template public main(t : Table)]
CREATE TABLE [t.name/] (
[for (col : Column | t.columns)]
  [col.name/] [col.type/][if (col.pk)] NOT NULL PRIMARY KEY[/if][if (col <> t.columns->last())],[/if]
[/for]
);
[/template]
```

**Saída SQL:**
```sql
CREATE TABLE Professor (
  matricula VARCHAR(64) NOT NULL PRIMARY KEY,
  nome VARCHAR(255)
);
```

### Exemplo 2: Usando Queries OCL

**Template Acceleo:**
```acceleo
[query public getPrimaryKey(t : Table) : String =
  t.columns->filter(c | c.pk)->collect(c | c.name)->first()
/]

[template public main(t : Table)]
ALTER TABLE [t.name/] ADD PRIMARY KEY ([getPrimaryKey(t)/]);
[/template]
```

**Saída:**
```sql
ALTER TABLE Professor ADD PRIMARY KEY (matricula);
```

### Exemplo 3: Geração de Índices

**Template Acceleo:**
```acceleo
[template public generateIndices(t : Table)]
[for (col : Column | t.columns)]
[if (col.name.toLowerCase().contains('id'))]
CREATE INDEX idx_[t.name/]_[col.name/] ON [t.name/] ([col.name/]);
[/if]
[/for]
[/template]
```

**Saída:**
```sql
CREATE INDEX idx_Emprestimo_id ON Emprestimo (id);
CREATE INDEX idx_Emprestimo_equipamentoCodigo ON Emprestimo (equipamentoCodigo);
```

---

## 📂 Estrutura de Arquivos

```
SistemaEmprestimos_CIM/
│
├── emf_atl/                              ← M2M e M2T
│   ├── GenerateSQL.mtl                   ← Template Acceleo (M2T)
│   ├── Relational.ecore                  ← Metamodelo PSM
│   ├── ecore2relational.atl              ← Transformação M2M
│   ├── sistema2relacional.atl            ← Transformação M2M
│   └── psm_relational_sample.xmi         ← PSM de exemplo
│
├── src/
│   └── SistemaEmprestimo/
│       └── generator/
│           └── GenerateSistemaEmprestimoSQL.java  ← Classe Geradora Java
│
├── output_sql/                           ← Pasta de saída (gerada)
│   ├── schema.sql                        ← Script principal (gerado)
│   └── ... outros arquivos ...
│
├── module2_module3_delivery/
│   ├── My.ecore                          ← Metamodelo CIM
│   └── constraints.ocl                   ← Constraints OCL
│
├── acceleo_generate.launch               ← Configuração Eclipse
├── ecore2relational.launch               ← Configuração Eclipse
├── headless_ocl_validator.launch         ← Configuração Eclipse
│
└── run_all.launch                        ← Launch Group (executa tudo)
```

---

## 🔧 Configuração do Ambiente

### Pré-requisitos

- **Eclipse IDE** com PDE (Plugin Development Environment)
- **Acceleo SDK** instalado (via Eclipse Marketplace)
- **EMF SDK** instalado
- **Java 21** ou superior

### Instalação de Plugins Eclipse

```
Help → Eclipse Marketplace → Pesquisar "Acceleo"
→ "Acceleo" by Obeo → Install
```

---

## 🐛 Troubleshooting

### Problema 1: "Template not found"

**Causa**: Template Acceleo não encontrada no classpath.

**Solução**:
```
1. Verify emf_atl/GenerateSQL.mtl existe
2. Check acceleo_generate.launch → modulePath está correto
3. Rebuild project (Project → Clean)
```

### Problema 2: "Model cannot be loaded"

**Causa**: Arquivo PSM XMI não encontrado ou inválido.

**Solução**:
```bash
# Validar estrutura do XMI
xmllint emf_atl/psm_relational_sample.xmi

# Verificar se metamodelo está registrado
# Adicionar em registerPackages():
resourceSet.getPackageRegistry().put(
  RelationalPackage.eINSTANCE.getNsURI(), 
  RelationalPackage.eINSTANCE
);
```

### Problema 3: "Metamodel not found"

**Causa**: Relational.ecore não registrado no ResourceSet.

**Solução**: Adicionar em `GenerateSistemaEmprestimoSQL.registerPackages()`:

```java
@Override
public void registerPackages(ResourceSet resourceSet) {
    super.registerPackages(resourceSet);
    if (!isInWorkspace(org.eclipse.emf.ecore.EcorePackage.class)) {
        resourceSet.getPackageRegistry().put(
            RelationalPackage.eINSTANCE.getNsURI(),
            RelationalPackage.eINSTANCE
        );
    }
}
```

### Problema 4: Encoding de caracteres UTF-8

**Causa**: Caracteres especiais não aparecem no SQL gerado.

**Solução**: Adicionar em `GenerateSQL.mtl`:
```acceleo
[comment encoding = UTF-8 /]  ← Primeira linha do arquivo
```

---

## 📚 Referências

- [Acceleo Documentation](https://www.eclipse.org/acceleo/)
- [EMF (Eclipse Modeling Framework)](https://www.eclipse.org/emf/)
- [MTL (MOF 2.0 Template Language)](https://www.omg.org/spec/MTL/)
- [Model-Driven Architecture (MDA)](https://www.omg.org/mda/)

---

## ✅ Checklist de Implementação

- [x] Template Acceleo criada (GenerateSQL.mtl)
- [x] Classe Java Geradora implementada (GenerateSistemaEmprestimoSQL.java)
- [x] Arquivo SQL de exemplo gerado (schema_sistema_emprestimos.sql)
- [x] Launch configuration (acceleo_generate.launch)
- [x] Documentação M2T completa (este arquivo)
- [ ] Testes automatizados de M2T
- [ ] CI/CD integração (GitHub Actions)
- [ ] Extensão para gerar código Java (ORM, DAOs, etc)

---

## 📝 Notas

**Data de Criação**: 31 de Maio de 2026  
**Versão**: 1.0  
**Autor**: Vitor BD32  
**Status**: ✓ Concluído - M2T Operacional  

---

**Próximas Melhorias:**
1. Integração com Hibernate (gerar entidades JPA)
2. Geração de testes unitários SQL
3. Suporte para múltiplos bancos de dados (PostgreSQL, Oracle, etc)
4. Geração de documentação HTML do schema
