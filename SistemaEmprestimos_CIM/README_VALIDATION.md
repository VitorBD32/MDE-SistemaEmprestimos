Validação OCL headless (instruções)
=================================

Este projeto inclui uma classe Java `tools.HeadlessOCLValidator` que realiza validação OCL em modo headless
e pode ser executada como uma aplicação Java dentro do Eclipse (sem UI). A classe lê:

- `module2_module3_delivery/My.ecore` (metamodelo PIM)
- todos os arquivos `.xmi` em `module2_module3_delivery/instances/`
- `module2_module3_delivery/constraints.ocl` (arquivo de restrições OCL no formato simples usado no projeto)

Como executar dentro do Eclipse
--------------------------------
1) Importe o projeto `SistemaEmprestimos_CIM` (se ainda não importado).
2) Verifique se o projeto tem no classpath as bibliotecas EMF e Eclipse OCL (normalmente presente ao usar Eclipse Modeling Tools).
3) Abra `tools/HeadlessOCLValidator.java` e execute: Run As -> Java Application.
4) Saída: a console imprimirá mensagens de carregamento e as violações encontradas (se houver). O aplicativo retorna código 0 em sucesso ou código diferente de zero em erro/violações.

Executar o grupo de execução (Launch Group)
----------------------------------------
1) No Eclipse abra o arquivo `run_all.launch` no Project Explorer.
2) Tente executar: Run As -> Launch Group (se a opção aparecer) ou Run -> Run As -> Launch.
3) Se o Eclipse não aceitar diretamente o arquivo `.launch`, crie manualmente um "Launch Group":
   - Run -> Run Configurations... -> Launch Group -> New
   - Adicione as configurações existentes:
     * `headless_ocl_validator.launch` (Java Application)
     * `ecore2relational.launch` (ATL Transformation)
     * `acceleo_generate.launch` (Acceleo Application)
   - Marque "Continue launch on errors" conforme preferência e salve.

O Launch Group executará as três etapas em sequência: validação OCL, transformação ATL M2MM e geração Acceleo M2T.

Fluxo recomendado de uso (automação manual simples)
--------------------------------------------------
1) Executar `HeadlessOCLValidator` (validação).
2) Se validação OK, execute `ecore2relational.launch` (ATL M2MM) para gerar `psm_relational.xmi`.
3) Execute `acceleo_generate.launch` (Acceleo M2T) para gerar SQL DDL em `output_sql/`.

Notas
-----
- O parser do `constraints.ocl` usado por `HeadlessOCLValidator` é simples e assume cada `context ... inv name:` seguido pela expressão na linha seguinte (como no arquivo fornecido). Para arquivos OCL mais complexos, a classe pode ser estendida.
- Se quiser que eu crie um script `.launch` integrado que execute validação e, em sequência, ATL e Acceleo automaticamente, posso criar uma configuração de execução (Launch Group) ou um plugin que lance as etapas em sequência. Peça que eu gere isso e eu adicionarei.