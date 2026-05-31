Objetivo
--------
Converter o gerador standalone para uma solução baseada em EMF (PIM), um módulo ATL (M2M)
que produz um PSM (`Relational.ecore`) e um módulo Acceleo (M2T) que gera SQL DDL.

Arquivos criados
- `Relational.ecore` — metamodelo PSM (tabelas/colunas)
- `sistema2relational.atl` — módulo ATL para gerar um modelo PSM a partir do modelo PIM (instâncias)
- `GenerateSQL.mtl` — template Acceleo que gera SQL DDL a partir do modelo PSM

Passo-a-passo (Eclipse) — preparar projeto
-------------------------------------------
1) Pré-requisitos
   - Eclipse IDE for Modeling (recomendo Eclipse Modeling Tools) com os plugins:
     * EMF (já incluso no pacote Modeling Tools)
     * ATL (Eclipse ATL plugin)
     * Acceleo (M2T) ou Acceleo SDK

2) Importar metamodelos
   - No Project Explorer do Eclipse: crie um novo projeto de model (ou plug-in) ou apenas importe os arquivos `My.ecore` e `Relational.ecore` para um projeto existente.
   - Registrar os metamodelos no workspace (abrir o `.ecore` no editor EMF é suficiente).

3) Criar/abrir um modelo PIM (instância)
   - Se você já tem `instances/Professor1.xmi`, `Equipamento1.xmi`, `Emprestimo1.xmi`, importe-os no workspace.
   - Abra-os com o XML Editor ou com o editor gerado pelo EMF (se você gerou o código EMF). Importante: os arquivos XMI precisam referenciar `My.ecore` no xsi:schemaLocation.

4) Executar transformação ATL (M2M)
   - Crie um Run Configuration (ATL) no Eclipse: New -> ATL Transformation
   - Configure:
     * Model (IN): o seu modelo PIM (ex.: `Emprestimo.xmi`) — registre `sistema_emprestimo` metamodel (apontar para `My.ecore`) e o arquivo XMI.
     * Model (OUT): novo modelo Relational (ex.: `psm_relational.xmi`) — use `Relational.ecore` como metamodel de saída.
     * Module: aponte para `sistema2relational.atl` criado em `emf_atl/`.
   - Execute. Saída: `psm_relational.xmi` contendo instâncias do metamodel `relational` (Tables + Columns).

5) Executar Acceleo (M2T) para gerar SQL
   - Crie um projeto Acceleo (File -> New -> Acceleo project). Adicione `GenerateSQL.mtl` ao módulo.
   - Configure o launcher de Acceleo: marque o modelo de entrada como `psm_relational.xmi` e defina o metamodelo `Relational.ecore`.
   - Configure a saída (ex.: pasta `output/`) e execute.
   - Resultado: arquivo `.sql` com os CREATE TABLE gerados.

Automação (.launch)
--------------------
Para facilitar a execução automática dentro do Eclipse eu incluí dois arquivos de configuração de execução (templates) em `emf_atl/launch/`:

- `ecore2relational.launch` — template para executar a transformação ATL (`ecore2relational.atl`).
- `acceleo_generate.launch` — template para executar o Acceleo (`GenerateSQL.mtl`) sobre o modelo PSM produzido.

Antes de usar as .launch, edite-as no Eclipse ou num editor de texto e substitua `PROJECT_NAME` e `path/to/...` pelos caminhos corretos do seu workspace/projeto. Exemplos de edição:

 - `sourceModelURI` no `ecore2relational.launch` deve apontar para o arquivo `My.ecore` ou para o modelo Ecore carregado no workspace (ex.: `platform:/resource/MDE-Entrega/module2_module3_delivery/My.ecore`).
 - `targetModelURI` deve apontar para onde você quer salvar o `psm_relational.xmi` (ex.: `platform:/resource/MDE-Entrega/module2_module3_delivery/emf_atl/psm_relational.xmi`).
 - `targetMetamodelURI` normalmente pode ser o caminho para `Relational.ecore` já importado no workspace.

Uso rápido no Eclipse
---------------------
1) Importe/coloque os arquivos em um projeto do workspace (ex.: `MDE-Entrega`).
2) Abra o arquivo `.launch` no Eclipse e ajuste as URIs (substitua `PROJECT_NAME`).
3) Run -> Run As -> Launch Configurations... -> selecione `ecore2relational.launch` e Execute.
4) Após a transformação, execute `acceleo_generate.launch` (ajuste também o `modelURI` caso necessário) para gerar os arquivos SQL em `output_sql/`.

Notas finais
-----------
Se preferir, eu posso gerar automaticamente os `.launch` já preenchidos com o caminho correto do projeto (ex.: `platform:/resource/MDE-Entrega/…`) — para isso confirme o nome do projeto Eclipse que você usará ao importar os arquivos (ex.: `MDE-Entrega` ou `SistemaEmprestimos_CIM`).

Notas e recomendações
--------------------
- O `sistema2relational.atl` que forneci é um módulo simples de prova de conceito: ele cria as três tabelas (Professor, Equipamento, Emprestimo) quando encontra pelo menos um elemento do PIM. Em projetos reais você costuma criar regras mais robustas que:
  * inspecionam o metamodelo (para gerar tabelas a partir de classes),
  * geram colunas dinamicamente a partir de atributos/referências do metamodelo,
  * preservam relacionamentos e chaves estrangeiras com mais critérios.
- Se quiser, eu posso:
  1) ajustar `sistema2relational.atl` para gerar o PSM dinamicamente a partir do próprio metamodelo (`My.ecore`) — isso seria uma transformação M2MM (metamodel-to-metamodel) mais adequada para gerar schemas a partir do PIM;
  2) gerar um módulo ATL que transforma instâncias PIM em instâncias PSM (linhas/tuplas), se esse for o objetivo;
  3) criar uma configuração de execução (arquivos `.launch`) para executar ATL/Acceleo automaticamente no Eclipse.

Próximo passo sugerido
---------------------
Diga qual variante prefere que eu implemente:
- A: transformar dinamicamente o metamodelo `My.ecore` em `Relational.ecore` (M2MM) — gera tabelas/colunas automaticamente a partir das classes/atributos do PIM;
- B: transformar instâncias PIM em instâncias PSM (linhas/tuplas) — útil se pretende gerar dados além do esquema;
- C: criar `.launch` e um pacote pronto para importar no Eclipse (ATL + Acceleo) com tudo configurado para execução imediata.