# PIM Report — Sistema de Empréstimos de Equipamentos
## Módulo 2: Especificação Independente de Plataforma (PIM)
**Disciplina:** Engenharia Dirigida por Modelos (MDE)  
**Professor:** Marcus Vinícius Carvalho  
**Data de Entrega:** 23 de Abril de 2026  

---

## 1. Visão Geral

Este relatório documenta os artefatos e decisões de modelagem do **Módulo 2 (PIM)** do projeto semestral de MDE. O objetivo foi criar o Modelo Independente de Plataforma (PIM) utilizando o metamodelo Ecore do Eclipse Modeling Framework (EMF), com restrições OCL para garantir a integridade das instâncias.

O sistema modela o fluxo de empréstimo de equipamentos de laboratório em uma instituição de ensino, onde professores solicitam equipamentos e o sistema rastreia o ciclo de vida desses empréstimos.

---

## 2. Glossário de Termos do Domínio

| Termo | Descrição |
|---|---|
| **Professor** | Docente da instituição que realiza a solicitação de empréstimo de equipamento. Identificado por nome, matrícula funcional e departamento. |
| **Equipamento** | Item do laboratório disponível para empréstimo. Identificado por nome, código de tombamento patrimonial e status de disponibilidade. |
| **Empréstimo** | Registro formal da cessão temporária de um equipamento a um professor. Contém datas de retirada e devolução prevista, e referencia o professor responsável e o equipamento cedido. |
| **Matrícula** | Identificador único e funcional do professor na instituição. Deve ser única no sistema. |
| **Código de Tombamento** | Número patrimonial único que identifica fisicamente cada equipamento no inventário da instituição. |
| **isDisponivel** | Atributo booleano do Equipamento que indica se o item pode ser retirado para novo empréstimo. |
| **dataRetirada** | Data em que o professor efetivamente retirou o equipamento. |
| **dataDevolucaoPrevista** | Data combinada para devolução do equipamento. Deve ser maior ou igual a dataRetirada. |

---

## 3. Metamodelo (Ecore)

### 3.1 Localização
O metamodelo canônico está em: `model/My.ecore`  
nsURI: `http://www.example.org/sistemaemprestimo`  
nsPrefix: `sistemaemprestimo`

### 3.2 Classes e Atributos

#### Professor
| Feature | Tipo | Multiplicidade | Descrição |
|---|---|---|---|
| nome | EString | 0..1 | Nome completo do professor |
| matricula | EString | 0..1 | Matrícula funcional (deve ser única) |
| departamento | EString | 0..1 | Departamento de lotação |

#### Equipamento
| Feature | Tipo | Multiplicidade | Descrição |
|---|---|---|---|
| nome | EString | 0..1 | Nome/descrição do equipamento |
| codigoTombamento | EInt | 0..1 | Código patrimonial único |
| isDisponivel | EBoolean | 0..1 | Disponibilidade para empréstimo |

#### Emprestimo
| Feature | Tipo | Multiplicidade | Descrição |
|---|---|---|---|
| dataRetirada | EDate | 0..1 | Data de retirada do equipamento |
| dataDevolucaoPrevista | EDate | 0..1 | Data prevista de devolução |
| equipamentoEmprestado | Equipamento | 1..1 | Referência obrigatória ao equipamento |
| professorResponsavel | Professor | 1..1 | Referência obrigatória ao professor |

### 3.3 Decisões de Modelagem

1. **Referências obrigatórias em Emprestimo**: `equipamentoEmprestado` e `professorResponsavel` possuem `lowerBound="1"`, tornando-os obrigatórios. Um empréstimo sem professor ou sem equipamento seria semanticamente inválido.

2. **Separação de entidades**: Professor, Equipamento e Emprestimo são classes independentes ligadas por referências (não composição). Isso permite que um equipamento ou professor seja referenciado por múltiplos empréstimos ao longo do tempo.

3. **isDisponivel como booleano**: Optou-se por um atributo booleano simples em vez de um tipo enumerado, pois o domínio exige apenas dois estados relevantes para empréstimo (disponível / indisponível).

4. **Datas como EDate**: Utiliza-se o tipo `EDate` do EMF para representar datas sem componente de horário, suficiente para o controle de prazos de empréstimo.

---

## 4. Restrições OCL

As restrições estão em: `ocl/constraints.ocl`

### 4.1 matriculaUnica (Professor)
```ocl
context sistema_emprestimo::Professor
inv matriculaUnica:
    sistema_emprestimo::Professor.allInstances()->isUnique(p | p.matricula)
```
**Justificativa:** A matrícula é o identificador funcional do professor; duplicidade causaria ambiguidade no rastreamento de responsabilidade pelos empréstimos.

### 4.2 equipamentoDisponivel (Emprestimo)
```ocl
context sistema_emprestimo::Emprestimo
inv equipamentoDisponivel:
    self.equipamentoEmprestado <> null implies self.equipamentoEmprestado.isDisponivel
```
**Justificativa:** Não faz sentido registrar um empréstimo de um equipamento que já está emprestado ou fora de serviço.

### 4.3 devolucaoDepoisDaRetirada (Emprestimo)
```ocl
context sistema_emprestimo::Emprestimo
inv devolucaoDepoisDaRetirada:
    self.dataRetirada <> null and self.dataDevolucaoPrevista <> null
    implies self.dataDevolucaoPrevista >= self.dataRetirada
```
**Justificativa:** A devolução não pode ser prevista para antes da retirada — isso seria logicamente impossível e indicaria erro de entrada de dados.

---

## 5. Instâncias XMI

| Arquivo | Tipo | Descrição |
|---|---|---|
| `instances/sample_instances.xmi` | Válida ✔ | Professor João Silva + Notebook Dell + Empréstimo (01/05 a 10/05/2026) |
| `instances/Emprestimo_invalido_devolucao.xmi` | Inválida ✗ | Viola `devolucaoDepoisDaRetirada`: devolução (20/04) < retirada (01/05) |

---

## 6. Evidências de Validação

O relatório completo de validação está em: `validation/report_validation_PIM.txt`

**Resumo:**
- `sample_instances.xmi`: **PASSOU** em todas as 3 invariantes OCL.
- `Emprestimo_invalido_devolucao.xmi`: **FALHOU** na invariante `devolucaoDepoisDaRetirada` (comportamento esperado).

---

## 7. Estrutura de Arquivos do PIM

```
MDE-SistemaEmprestimos/
├── model/
│   └── My.ecore                          # Metamodelo Ecore canônico (PIM)
├── instances/
│   ├── sample_instances.xmi              # Instância válida (Professor + Equipamento + Emprestimo)
│   └── Emprestimo_invalido_devolucao.xmi # Instância inválida (viola OCL)
├── ocl/
│   └── constraints.ocl                   # Restrições OCL (3 invariantes)
├── validation/
│   └── report_validation_PIM.txt         # Relatório de validação OCL
├── src/                                  # Código Java gerado pelo EMF
├── PIM-report.md                         # Este relatório
└── README.md                             # Instruções gerais e de validação
```

---

## 8. Conclusão

O PIM do Sistema de Empréstimos está completo com:
- Metamodelo Ecore consistente e sem duplicatas
- Três invariantes OCL cobrindo unicidade de matrícula, disponibilidade de equipamento e validade de datas
- Instâncias representativas (válida e inválida) para demonstração da validação
- Relatório de validação documentando os resultados esperados

O modelo está pronto para a próxima etapa (Módulo 3), onde serão desenvolvidas as transformações M2M (PIM → PSM) e M2T (geração de código).
