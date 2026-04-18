# 📦 Sistema de Empréstimos de Equipamentos — MDE com EMF

> Projeto acadêmico desenvolvido com **Engenharia Dirigida por Modelos (MDE)** utilizando o **Eclipse Modeling Framework (EMF)**. O sistema modela o fluxo de empréstimo de equipamentos de laboratório entre professores de uma instituição de ensino.

---

## ✅ Módulo 2 — PIM (Entrega 23/04/2026)

### Artefatos entregues

| Artefato | Localização | Descrição |
|---|---|---|
| Metamodelo canônico | `model/My.ecore` | Definição Ecore com 3 EClasses e referências corrigidas |
| Instâncias representativas | `instances/sample_instances.xmi` | 1 caso válido + 1 caso inválido |
| Restrições OCL | `ocl/constraints.ocl` | 3 invariantes: matrícula única, equipamento disponível, devolução após retirada |
| Relatório de validação | `validation/report_validation_PIM.txt` | Resultados esperados e instruções de reprodução |

### Como validar no Eclipse

**Pré-requisitos:**
- Eclipse IDE 2024-12 (distribuição *Eclipse Modeling Tools* recomendada)
- Plugin OCL Classic SDK instalado (via Eclipse Marketplace)
- Java 21 ou superior

**Passos:**
1. `File → Import → General → Existing Projects into Workspace` — selecionar a raiz do projeto.
2. Clique com o botão direito em `model/My.ecore` → **Register EPackages**.
3. Abra `instances/sample_instances.xmi` com o **Sample Reflective Ecore Model Editor**.
4. No editor do XMI: `Edit → Validate` — confira o *Problems View*:
   - `emp_valid` não deve gerar erros.
   - `emp_invalid_devolucao` deve gerar erro na invariante `devolucaoDepoisDaRetirada`.
5. Para validação explícita com OCL, abra `ocl/constraints.ocl` no editor OCL e use o *OCL Console*.

Consulte `validation/report_validation_PIM.txt` para os resultados esperados detalhados.

### Decisões de modelagem

- **`lowerBound="1"`** nas referências `equipamentoEmprestado` e `professorResponsavel`: todo empréstimo deve, obrigatoriamente, ter um equipamento e um professor associados. Caso o grupo prefira tornar as referências opcionais (`lowerBound="0"`), o valor pode ser ajustado no metamodelo e o código Java regerado via `My.genmodel`.
- O pacote OCL usa `sistema_emprestimo::` como qualificador de contexto (alinhado ao `name` do EPackage).
- Os projetos EcoRoute (exemplos de gerador Acceleo) foram movidos para `generators/` para não poluir a raiz.

---

---

## 📖 Sobre o Projeto

O **Sistema de Empréstimos** é um modelo de domínio criado dentro do contexto de **Engenharia Dirigida por Modelos (MDE — *Model-Driven Engineering*)**, uma abordagem de desenvolvimento de software que eleva os modelos a artefatos de primeira classe no processo de criação de sistemas.

O projeto define um **metamodelo Ecore** (o "esqueleto" do sistema) a partir do qual código Java é gerado automaticamente pelo EMF. Ele representa o ciclo de vida de um empréstimo acadêmico, desde o cadastro do professor e do equipamento até o registro da retirada e da devolução prevista.

### 🎯 Contexto de Uso

O sistema foi pensado para instituições de ensino e pesquisa que possuem laboratórios com equipamentos compartilhados. Professores solicitam empréstimos de equipamentos e o sistema rastreia quem tem qual equipamento, por quanto tempo, e se o item está disponível para empréstimo.

---

## 🧰 Tecnologias Utilizadas

| Tecnologia | Descrição |
|---|---|
| **Java 21** | Linguagem de implementação principal |
| **Eclipse IDE (PDE)** | Ambiente de desenvolvimento e execução |
| **Eclipse Modeling Framework (EMF)** | Framework para criação de modelos e geração de código |
| **Ecore** | Linguagem de metamodelagem do EMF |
| **XMI** | Formato XML para serialização de instâncias dos modelos |
| **UML** | Diagramas de modelagem de alto nível |
| **Sirius** | Ferramenta de visualização dos modelos (arquivos `.aird`, `.notation`) |

---

## 📁 Estrutura do Projeto

```
MDE-SistemaEmprestimos/
│
├── model/
│   └── My.ecore                         # Metamodelo canônico (PIM) ← versão única e correta
│
├── instances/
│   └── sample_instances.xmi             # Instâncias representativas (válida e inválida)
│
├── ocl/
│   └── constraints.ocl                  # Restrições OCL (3 invariantes)
│
├── validation/
│   └── report_validation_PIM.txt        # Relatório de validação esperada
│
├── src/
│   └── sistema_emprestimo/              # Pacote principal gerado pelo EMF
│       ├── Professor.java               # Interface da entidade Professor
│       ├── Equipamento.java             # Interface da entidade Equipamento
│       ├── Emprestimo.java              # Interface da entidade Empréstimo
│       ├── Sistema_emprestimoFactory.java
│       ├── Sistema_emprestimoPackage.java
│       ├── impl/                        # Implementações concretas
│       ├── util/                        # Classes utilitárias do EMF
│       └── validation/                  # Interfaces de validação
│
├── generators/                          # Exemplos de projetos geradores (EcoRoute — Módulo 3 ref.)
│   ├── EcoRoute-Agro-Model/
│   ├── EcoRoute.generator.sql/
│   └── EcoRoute.sql.generator/
│
├── META-INF/
│   └── MANIFEST.MF
│
├── My.genmodel                          # Modelo de geração de código EMF
├── SistemaEmprestimos_CIM.uml           # Diagrama UML — CIM (Módulo 1)
├── SistemaEmprestimos_CIM.aird          # Representação visual Sirius
├── plugin.xml
├── build.properties
└── text/
    └── description.txt
```

---

## 🗂️ Modelo de Dados

O sistema possui três entidades principais, definidas no metamodelo `My.ecore`:

### 👨‍🏫 Professor

Representa o docente responsável pelo empréstimo.

| Atributo | Tipo | Descrição |
|---|---|---|
| `nome` | `String` | Nome completo do professor |
| `matricula` | `String` | Número de matrícula funcional |
| `departamento` | `String` | Departamento ao qual está vinculado |

### 🔬 Equipamento

Representa um item do laboratório que pode ser emprestado.

| Atributo | Tipo | Descrição |
|---|---|---|
| `nome` | `String` | Nome/descrição do equipamento |
| `codigoTombamento` | `int` | Código patrimonial (tombamento) do equipamento |
| `isDisponivel` | `boolean` | Indica se o equipamento está disponível para empréstimo |

### 📋 Empréstimo

Representa o registro de um empréstimo, conectando um professor a um equipamento.

| Atributo/Referência | Tipo | Descrição |
|---|---|---|
| `dataRetirada` | `Date` | Data em que o equipamento foi retirado |
| `dataDevolucaoPrevista` | `Date` | Data prevista para a devolução |
| `equipamentoEmprestado` | `Equipamento` | Referência ao equipamento emprestado |
| `professorResponsavel` | `Professor` | Referência ao professor responsável |

---

## ✅ Requisitos Funcionais

Os requisitos funcionais descrevem **o que o sistema deve fazer** — as funcionalidades que o modelo suporta.

### RF01 — Cadastro de Professor
O sistema deve permitir o registro de professores com os dados: nome completo, matrícula funcional e departamento de lotação.

### RF02 — Cadastro de Equipamento
O sistema deve permitir o registro de equipamentos com nome, código de tombamento (identificador patrimonial único) e status de disponibilidade.

### RF03 — Consulta de Disponibilidade de Equipamento
O sistema deve permitir verificar se um equipamento está disponível para empréstimo por meio do atributo `isDisponivel`.

### RF04 — Registro de Empréstimo
O sistema deve permitir o registro de um novo empréstimo, associando um equipamento a um professor responsável, com a data de retirada e a data prevista de devolução.

### RF05 — Associação entre Professor e Equipamento
O sistema deve garantir que cada empréstimo esteja obrigatoriamente vinculado a exatamente um professor responsável e a exatamente um equipamento.

### RF06 — Rastreamento de Datas
O sistema deve registrar a data de retirada do equipamento e a data prevista para devolução em cada registro de empréstimo.

### RF07 — Serialização e Persistência do Modelo
O sistema deve ser capaz de serializar e desserializar instâncias do modelo em formato XMI, permitindo salvar e carregar o estado dos dados.

### RF08 — Criação de Instâncias por Fábrica
O sistema deve disponibilizar uma fábrica (`Sistema_emprestimoFactory`) para a criação padronizada de instâncias de `Professor`, `Equipamento` e `Emprestimo`.

### RF09 — Validação de Entidades
O sistema deve disponibilizar interfaces de validação (`EmprestimoValidator`, `EquipamentoValidator`, `ProfessorValidator`) para verificar a integridade dos dados das entidades.

### RF10 — Extensibilidade via Adaptadores
O sistema deve suportar extensão de comportamento por meio do padrão Adapter (`Sistema_emprestimoAdapterFactory`), permitindo adicionar novas funcionalidades sem modificar o modelo base.

---

## 🔒 Requisitos Não Funcionais

Os requisitos não funcionais descrevem **como o sistema deve se comportar** — qualidades e restrições de execução.

### RNF01 — Compatibilidade com Java 21
O sistema deve ser executado em ambientes com **Java SE 21** ou superior, conforme declarado no manifesto do plugin (`Bundle-RequiredExecutionEnvironment: JavaSE-21`).

### RNF02 — Conformidade com o Eclipse Modeling Framework
Todo o código gerado deve ser compatível com a API do **EMF** e seguir os contratos definidos pelo `EObject`, `EClass`, `EStructuralFeature` e demais elementos do framework.

### RNF03 — Geração de Código Automatizada
O código Java das entidades do modelo **não deve ser editado manualmente**. Qualquer alteração deve ser feita no metamodelo `My.ecore` e o código deve ser regerado via `My.genmodel`, garantindo consistência entre modelo e implementação.

### RNF04 — Modularidade como Plugin Eclipse
O sistema deve ser empacotado como um **plugin OSGi** para o Eclipse IDE, com dependências explicitamente declaradas no `MANIFEST.MF` e com pacotes exportados de forma controlada.

### RNF05 — Interoperabilidade via XMI
As instâncias do modelo devem ser persistidas no formato **XMI (XML Metadata Interchange)**, um padrão aberto da OMG que garante interoperabilidade com outras ferramentas compatíveis com EMF e MOF.

### RNF06 — Manutenibilidade do Modelo
A estrutura do sistema deve seguir os **padrões de projeto do EMF** (Factory, Adapter, Switch/Visitor), facilitando a manutenção, extensão e compreensão do código gerado.

### RNF07 — Legibilidade e Documentação do Modelo
O metamodelo deve ser autodescritivo, com nomes de classes e atributos em português e alinhados ao domínio do problema, facilitando sua leitura por desenvolvedores e stakeholders não técnicos.

### RNF08 — Baixo Acoplamento entre Entidades
As entidades devem ser relacionadas por **referências EMF** (e não por herança ou composição forte), permitindo que cada entidade seja utilizada de forma independente em outros contextos ou sistemas.

### RNF09 — Portabilidade
Por ser baseado em Eclipse EMF e Java, o projeto deve funcionar em qualquer sistema operacional que possua uma JVM compatível com Java 21 e o Eclipse IDE instalado (Windows, Linux, macOS).

### RNF10 — Conformidade com Padrões MDE/OMG
O projeto deve seguir os princípios da **Arquitetura Dirigida por Modelos (MDA)** da OMG, operando no nível de **CIM (Computation Independent Model)**, com separação clara entre o modelo conceitual e os detalhes tecnológicos de implementação.

---

## 🚀 Como Executar o Projeto

### Pré-requisitos

- **Java 21** ou superior instalado
- **Eclipse IDE** com suporte a PDE (Plugin Development Environment)
- **EMF SDK** instalado no Eclipse (disponível via Eclipse Marketplace)
- Opcional: **Sirius** para visualização dos diagramas

### Passo a Passo

**1. Clonar o repositório**
```bash
git clone https://github.com/VitorBD32/MDE-SistemaEmprestimos.git
```

**2. Importar no Eclipse**
- Abra o Eclipse IDE
- Vá em `File → Import → General → Existing Projects into Workspace`
- Selecione o diretório do projeto clonado
- Clique em `Finish`

**3. Construir o projeto**
- Clique com o botão direito no projeto → `Build Project`
- O Eclipse compilará os fontes Java para o diretório `/bin`

**4. Regenerar código a partir do metamodelo (opcional)**
> Necessário apenas se você modificar o arquivo `My.ecore`

- Clique com o botão direito em `My.genmodel`
- Selecione `Generate All`
- O EMF regerará todas as classes Java automaticamente

**5. Usar o modelo programaticamente**

```java
// Importar a fábrica do modelo
Sistema_emprestimoFactory factory = Sistema_emprestimoFactory.eINSTANCE;

// Criar um Professor
Professor professor = factory.createProfessor();
professor.setNome("Dr. João Silva");
professor.setMatricula("M2024001");
professor.setDepartamento("Engenharia de Computação");

// Criar um Equipamento
Equipamento equipamento = factory.createEquipamento();
equipamento.setNome("Osciloscópio Digital");
equipamento.setCodigoTombamento(98765);
equipamento.setIsDisponivel(true);

// Registrar um Empréstimo
Emprestimo emprestimo = factory.createEmprestimo();
emprestimo.setDataRetirada(new Date());
emprestimo.setDataDevolucaoPrevista(new Date(System.currentTimeMillis() + 7L * 24 * 60 * 60 * 1000)); // 7 dias a partir de hoje
emprestimo.setEquipamentoEmprestado(equipamento);
```

**6. Salvar instâncias em XMI**

```java
ResourceSet resourceSet = new ResourceSetImpl();
resourceSet.getResourceFactoryRegistry()
    .getExtensionToFactoryMap()
    .put("xmi", new XMIResourceFactoryImpl());

Resource resource = resourceSet.createResource(
    URI.createURI("file:///caminho/para/emprestimo.xmi")
);
resource.getContents().add(emprestimo);
resource.save(null); // Salva em disco no formato XMI
```

---

## 🧩 Padrões de Projeto Utilizados

| Padrão | Classe/Interface | Descrição |
|---|---|---|
| **Factory** | `Sistema_emprestimoFactory` | Centraliza a criação de instâncias das entidades |
| **Visitor / Switch** | `Sistema_emprestimoSwitch` | Permite percorrer a hierarquia do modelo com lógica variável |
| **Adapter** | `Sistema_emprestimoAdapterFactory` | Adapta objetos do modelo para novas funcionalidades sem alterá-los |
| **Registry** | `Sistema_emprestimoPackage` | Registro central dos metadados do metamodelo EMF |

---

## 📐 Diagrama do Modelo

```
┌──────────────────────┐       ┌────────────────────────────┐
│      Professor       │       │         Emprestimo          │
│──────────────────────│       │────────────────────────────│
│ nome : String        │◄──────│ dataRetirada : Date         │
│ matricula : String   │       │ dataDevolucaoPrevista : Date │
│ departamento : String│       │ professorResponsavel ───────►│
└──────────────────────┘       │ equipamentoEmprestado ──────►│
                               └────────────────────────────┘
                                            │
                               ┌────────────▼───────────────┐
                               │         Equipamento         │
                               │────────────────────────────│
                               │ nome : String               │
                               │ codigoTombamento : int      │
                               │ isDisponivel : boolean      │
                               └────────────────────────────┘
```

---

## 👤 Autor

**Vitor BD32**
- Projeto desenvolvido para fins acadêmicos na disciplina de **Engenharia Dirigida por Modelos (MDE)**

---

## 📄 Licença

Este projeto é de caráter acadêmico e foi desenvolvido para fins educacionais. Consulte o repositório para informações sobre licenciamento.
