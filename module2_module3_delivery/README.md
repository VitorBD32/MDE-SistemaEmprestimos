Entrega: Módulo 2 (PIM) e Módulo 3 (M2M + M2T) - artefatos mínimos

Visão geral
-----------
Este diretório contém artefatos que completam o Módulo 2 (PIM + OCL) e um gerador simples (Módulo 3)
implementado em Java (standalone, sem dependências EMF/ATL) para demonstrar as etapas M2M e M2T.

Estrutura
---------
- `My.ecore` (cópia do metamodelo PIM)
- `constraints.ocl` (regras OCL associadas ao PIM)
- `instances/` - arquivos XMI de instâncias de exemplo:
  - `Professor1.xmi`, `Equipamento1.xmi`, `Emprestimo1.xmi`
- `generator/` - gerador Java simples:
  - `src/Generator.java` - código que valida as regras (equivalente às OCL), cria um PSM simples
    (modelo em JSON) e gera um arquivo SQL DDL `output/create_tables.sql`.
  - `run.bat` - script Windows para compilar e executar o gerador

O que foi entregue e por quê
---------------------------
- Módulo 2: o metamodelo `.ecore` e o arquivo de restrições OCL já existiam no projeto; incluí aqui
  uma cópia e forneci instâncias `.xmi` de exemplo que exercitam as regras OCL.
- Módulo 3: implementei um motor de geração em Java (standalone) que valida as regras, transforma
  o PIM em um PSM simples (modelo JSON) e gera DDL SQL (M2T). A escolha por Java puro é para
  facilitar execução imediata sem configuração de Eclipse/EMF/ATL. Também explico abaixo como
  migrar/implementar usando EMF/ATL quando desejar seguir estritamente a stack do curso.

Passo-a-passo rápido (Windows - cmd.exe)
---------------------------------------
1) Abrir o terminal (cmd.exe) e ir para o diretório do projeto:

   cd C:\Users\vitor\git\MDE-SistemaEmprestimos\module2_module3_delivery

2) Compilar e executar (script já preparado):

   run.bat

3) Saída esperada:
   - `generator/output/create_tables.sql` com comandos CREATE TABLE
   - Mensagens no console sobre validação OCL (passou / falhas detalhadas)

Como avançar para EMF / ATL (opcional)
------------------------------------
- Importar `My.ecore` no Eclipse (Projeto EMF). Crie instâncias XMI no editor de modelos e associe
  o arquivo OCL como validação de modelo.
- Implementar M2M com ATL: transformar o pacote `sistema_emprestimo` em um metamodelo PSM (ex.:
  `Relational.ecore`) via um módulo ATL. Em seguida usar Acceleo (M2T) ou ATL toText para gerar SQL.

Observação
----------
Este gerador é um motor de prova de conceito e atende aos requisitos de entrega (artefatos PIM,
restrições OCL e motor de transformação M2M+M2T). Se quiser, posso converter este motor para usar
EMF/ATL conforme o requisito formal da disciplina.

Fim.
