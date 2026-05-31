# 🔧 Como Resolver o ClassNotFoundException

## ❌ Problema
```
Erro: Não foi possível localizar nem carregar a classe principal tools.HeadlessOCLValidator
Causada por: java.lang.ClassNotFoundException: tools.HeadlessOCLValidator
```

## ✅ Solução

O problema é que as classes Java não estão compiladas. Você precisa recompilar o projeto usando **Eclipse** (a abordagem mais confiável).

### Passo 1: Abrir o projeto no Eclipse

1. Abra **Eclipse**
2. Vá em **File → Open Projects from File System...**
3. Navegue até: `C:\Users\vitor\git\MDE-SistemaEmprestimos`
4. Clique em **Select Folder** → **Open**

### Passo 2: Deixar o Eclipse compilar

1. Projeto será automaticamente compilado pelo Eclipse
2. Aguarde aparecer o ícone ✅ no painel de projetos (sem erros)
3. Isso criará os arquivos .class em `bin/`

### Passo 3: Executar o Validator

**Opção A - Dentro do Eclipse:**
- Clique com botão direito no projeto
- Vá em **Run As → Run Configurations...**
- Clique em **headless_ocl_validator**
- Clique em **Run**

**Opção B - Linha de comando:**
```cmd
C:\Users\vitor\git\MDE-SistemaEmprestimos\run_ocl_validator.bat
```

---

## 📋 Por que as classes não estão compiladas?

1. Limpei o diretório `bin/` para remover bytecode antigo que causava conflitos
2. Isso resolveu o erro de "SecurityException" mas criou a necessidade de recompilar
3. Eclipse faz a recompilação automaticamente quando abre o projeto

---

## ✨ Resumo da Solução Completa

| Problema | Solução |
|----------|---------|
| Feature `equipamentoCodigo` not found | ✅ Adicionado ao My.ecore |
| Constraint OCL com EDate | ✅ Corrigido para isGreaterOrEqual() |
| SecurityException - JARs duplicados | ✅ Limpeza do classpath e bytecode |
| ClassNotFoundException | ✅ Recompilar via Eclipse |

---

## 🎯 Próximas etapas após compilar

1. **Executar o validator** usando um dos métodos acima
2. **Verificar os resultados** - deve validar todas as 3 restrições OCL
3. **Conferir se há violações** - se todas passarem, validação OK ✅

