Instrucoes para executar a cadeia M2M (ATL) + M2T (Acceleo) e um runner Java local

Conteudo do repositório relacionado:
- `emf_atl/` : contem `sistema2relational.atl`, `ecore2relational.atl`, `Relational.ecore`, `GenerateSQL.mtl` (MTL para gerar SQL a partir do modelo Relational) e um `psm_relational_sample.xmi` de amostra.
- `module2_module3_delivery/generator/Generator.java` : utilitario Java que faz parse dos XMI (instances), valida regras e gera `psm_model.json` e `create_tables.sql` em `output/`.

Opcoes de execucao

1) Execucao rapida (headless) via Java (recomendada se voce nao quer abrir o Eclipse):

  - Abra um cmd.exe e navegue para:
    C:\Users\vitor\git\MDE-SistemaEmprestimos\module2_module3_delivery\generator

  - Verifique que existe um diretorio `instances` com os XMI de entrada (por exemplo `Professor.xmi`, `Equipamento.xmi`, `Emprestimo.xmi`).
    Se quiser testar sem instancias, ainda assim o gerador vai gerar o SQL baseado na definicao interna.

  - Execute o batch criado:

```bat
run_m2m_m2t.bat
```

  - Saida esperada em `output/`:
    - `psm_model.json` (PSM gerado em JSON)
    - `create_tables.sql` (DDL gerado)

2) Execucao via Eclipse (ATL + Acceleo) — fluxo completo M2M + M2T (recomendado para integracao EMF/ATL/Acceleo):

  - Abra o Eclipse (com plugins ATL e Acceleo instalados) e importe o projeto `MDE-SistemaEmprestimos` ou apenas a pasta `SistemaEmprestimos_CIM`.
  - Localize em `SistemaEmprestimos_CIM/emf_atl/` os seguintes arquivos:
    - `sistema2relational.atl` e `ecore2relational.atl` (transformacoes ATL)
    - `Relational.ecore` (metamodelo de destino)
    - `GenerateSQL.mtl` (template M2T — Acceleo) ou use as launch configurations fornecidas.
  - Use as `.launch` prontas (na raiz do projeto):
    - `ecore2relational.launch` : para rodar a transformacao Ecore -> Relational (M2M)
    - `acceleo_generate.launch` : para rodar o Acceleo / MTL (gerar SQL a partir do modelo Relational)
    - `run_all.launch` : executa a cadeia (se configurado)

  - Caso precise criar uma Run Configuration manualmente:
    - Para ATL: Run -> Run Configurations -> ATL Transformation
      - Input Model: a instancia/arquivo XMI do PIM (ou My.ecore como modelo se aplicavel)
      - Output Model: defina um arquivo XMI de saida (ex.: `psm_relational.xmi`) e associe `Relational.ecore` como metamodelo.
    - Para Acceleo: Run -> Run Configurations -> Acceleo Application
      - Module: selecione o `GenerateSQL.mtl` ou o modulo apropriado
      - Model: selecione o `psm_relational.xmi` gerado pelo ATL
      - Output folder: escolha a pasta onde deseja que o `.sql` seja escrito

Observacoes finais
- O batch `run_m2m_m2t.bat` compila e executa `Generator.java`, que encapsula um caminho M2M/M2T simples e gera o SQL diretamente (útil para testes e entrega). Se voce quer rodar ATL+MTL via Eclipse para reproduzir academicamente o Módulo 3, use as `.launch` fornecidas.

Se quiser, eu executo agora o `run_m2m_m2t.bat` para gerar o SQL automaticamente (preciso apenas rodar o batch e mostrar o output). Deseja que eu execute agora? (vou rodar automaticamente em seguida se voce confirmar implicitamente)
