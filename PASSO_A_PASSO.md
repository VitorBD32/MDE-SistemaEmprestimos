# 🎯 GUIA PASSO A PASSO - Recompilar e Executar

## ⏱️ Tempo estimado: 5 minutos

---

## PASSO 1️⃣: Recompilar no Eclipse

### 1.1 - Abra o Eclipse
- Clique no ícone do Eclipse ou execute: `eclipse.exe`
- Aguarde carregar

### 1.2 - Importar o projeto
```
Menu: File → Open Projects from File System...
```

### 1.3 - Selecionar a pasta
```
Clique em: "Directory..."
Navegue até: C:\Users\vitor\git\MDE-SistemaEmprestimos
Clique em: "Select Folder"
Clique em: "Finish"
```

### 1.4 - Aguardar compilação
```
Aguarde o Eclipse compilar (pode levar 30-60 segundos)
Procure por: ✅ Nenhum erro de compilação
```

---

## PASSO 2️⃣: Executar o Validator

### Opção A - Via Eclipse (RECOMENDADO)

```
1. Clique com botão DIREITO no projeto
2. Run As → Run Configurations...
3. Selecione: headless_ocl_validator
4. Clique: Run
```

### Opção B - Via Script (Linha de Comando)

Abra um terminal (cmd.exe) e execute:
```cmd
C:\Users\vitor\git\MDE-SistemaEmprestimos\run_ocl_validator.bat
```

---

## PASSO 3️⃣: Verificar Resultados

### ✅ Saída ESPERADA (Sucesso)

```
====================================
Executando Headless OCL Validator
====================================
Projeto: C:\Users\vitor\git\MDE-SistemaEmprestimos

Headless OCL Validator
Project root: C:\Users\vitor\git\MDE-SistemaEmprestimos
Constraints parsed: 3
Loaded Ecore: sistema_emprestimo nsURI=http://www.example.org/sistemaemprestimo
Loading instance: Emprestimo1.xmi
Loading instance: Equipamento1.xmi
Loading instance: Professor1.xmi
Validation OK: todas as restrições passaram.
```

### ❌ Se aparecer erro

**Erro 1: ClassNotFoundException**
```
→ Certifique-se de que Eclipse compilou (✅ sem erros)
→ Feche e reabra Eclipse
→ Project → Clean → Clean All Projects
```

**Erro 2: OCL Parsing Error**
```
→ Verifique que constraints.ocl foi editado corretamente
→ Procure por: isGreaterOrEqual (não >=)
```

**Erro 3: Feature not found**
```
→ Verifique que My.ecore tem equipamentoCodigo e professorMatricula
→ Salve o arquivo (Ctrl+S)
```

---

## 📊 O que foi Corrigido

| # | Problema | Status |
|---|----------|--------|
| 1 | Feature `equipamentoCodigo` não existe | ✅ CORRIGIDO |
| 2 | OCL constraint com EDate inválido | ✅ CORRIGIDO |
| 3 | SecurityException - JARs duplicados | ✅ CORRIGIDO |
| 4 | Classes não compiladas | ⏳ **FAÇA AGORA** |

---

## 💾 Checklist Antes de Executar

- ☑️ Eclipse está aberto?
- ☑️ Projeto foi importado?
- ☑️ Eclipse compilou (✅ nenhum erro)?
- ☑️ Pasta `bin/` tem arquivos `.class`?
- ☑️ Arquivo `My.ecore` foi salvo?
- ☑️ Arquivo `constraints.ocl` foi salvo?

---

## 🎯 Resultado Final

Após completar todos os passos, você terá:
```
✅ Modelo Ecore correto (com novos atributos)
✅ Constraints OCL válidas
✅ Classes compiladas
✅ Validator funcionando
✅ Validação dos dados do modelo
```

---

## 📞 Arquivos de Referência

Se precisar de mais informações, consulte:
- `VALIDATOR_FIX.md` - Detalhes técnicos completos
- `RESUMO_COMPLETO_RESOLUCAO.md` - Resumo de todas as mudanças
- `COMO_RESOLVER_CLASSNOTFOUND.md` - Resolução específica do ClassNotFoundException

---

## ✨ Parabéns!

Se chegou aqui, todos os problemas foram **resolvidos** e documentados. 🎉

Agora é só compilar e executar!
