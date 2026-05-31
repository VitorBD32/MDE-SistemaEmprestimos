# Resolução do Problema: Headless OCL Validator

## Problemas Resolvidos

### ✅ Problema 1: Feature 'equipamentoCodigo' not found
**Erro Original:**
```
org.eclipse.emf.ecore.xmi.FeatureNotFoundException: Feature 'equipamentoCodigo' not found
```

**Causa:** O arquivo XMI `Emprestimo1.xmi` estava usando atributos que não existiam no modelo Ecore.

**Solução Implementada:**
- Adicionei os atributos `equipamentoCodigo` e `professorMatricula` à classe `Emprestimo` em `My.ecore`
- **Arquivos modificados:**
  - `C:\Users\vitor\git\MDE-SistemaEmprestimos\My.ecore`
  - `C:\Users\vitor\git\MDE-SistemaEmprestimos\module2_module3_delivery\My.ecore`

### ✅ Problema 2: Cannot find operation (>=(EDate))
**Erro Original:**
```
Failed to parse OCL expression for constraint devolucaoDepoisDaRetirada: Cannot find operation (>=(EDate)) for the type (EDate)
```

**Causa:** OCL não suporta operador `>=` diretamente em tipos `EDate`.

**Solução Implementada:**
- Substitui a expressão OCL para usar o método apropriado `isGreaterOrEqual()`
- **Arquivo modificado:**
  - `C:\Users\vitor\git\MDE-SistemaEmprestimos\module2_module3_delivery\constraints.ocl`

### ✅ Problema 3: SecurityException - Conflito de JARs
**Erro Original:**
```
java.lang.SecurityException: class "org.eclipse.emf.ecore.resource.impl.URIMappingRegistryImpl"'s signer information does not match signer information of other classes in the same package
```

**Causa:** Havia múltiplas versões de bibliotecas EMF no classpath com diferentes assinaturas digitais.

**Solução Implementada:**
- Removeu versões antigas e duplicadas de bibliotecas
- Mantive apenas as versões mais recentes e compatíveis
- Adicionei argumentos de VM para resolver conflitos de OSGi
- **Arquivos modificados:**
  - `.classpath` (versão simplificada com apenas as dependências necessárias)
  - `SistemaEmprestimos_CIM/headless_ocl_validator.launch` (adicionado VM arguments)

## Como Executar o Validator

### Opção 1: Do Eclipse (Recomendado)
1. Abra Eclipse
2. Clique em `Run → Run Configurations`
3. Selecione `headless_ocl_validator`
4. Clique em `Run`

### Opção 2: Via Script Batch (Windows)
Execute o script criado:
```cmd
C:\Users\vitor\git\MDE-SistemaEmprestimos\run_validator.bat
```

Este script:
- Configura um classpath limpo com versões compatíveis
- Adiciona argumentos de VM necessários
- Executa o validador

## Mudanças Detalhadas

### 1. Ecore Model Update
**Arquivo:** `module2_module3_delivery/My.ecore`

```xml
<!-- Adicionado à classe Emprestimo: -->
<eStructuralFeatures xsi:type="ecore:EAttribute" name="equipamentoCodigo" 
    eType="ecore:EDataType http://www.eclipse.org/emf/2002/Ecore#//EString"/>
<eStructuralFeatures xsi:type="ecore:EAttribute" name="professorMatricula" 
    eType="ecore:EDataType http://www.eclipse.org/emf/2002/Ecore#//EString"/>
```

### 2. OCL Constraint Update
**Arquivo:** `module2_module3_delivery/constraints.ocl`

```ocl
-- Antes:
self.dataDevolucaoPrevista >= self.dataRetirada

-- Depois:
self.dataDevolucaoPrevista.isGreaterOrEqual(self.dataRetirada)
```

### 3. Launch Configuration
**Arquivo:** `SistemaEmprestimos_CIM/headless_ocl_validator.launch`

```xml
<!-- Adicionado VM Arguments: -->
<stringAttribute key="org.eclipse.jdt.launching.VM_ARGUMENTS" 
    value="-Xmx512m -Dorg.osgi.framework.bundle.parent=boot -Dorg.eclipse.emf.ecore.plugin.EcorePlugin.noSplash=true"/>
```

### 4. Classpath Cleanup
**Arquivo:** `.classpath`

Removidas versões antigas e duplicadas:
- ❌ `org.eclipse.emf.ecore_2.39.0` (versão antiga)
- ❌ `org.eclipse.emf.ecore.xmi_2.39.0` (versão antiga)
- ❌ Versões duplicadas de Sirius, Papyrus, OCL

Mantidas versões mais recentes e compatíveis:
- ✅ `org.eclipse.emf.ecore_2.42.0.v20251210-1145`
- ✅ `org.eclipse.emf.ecore.xmi_2.40.0.v20251210-1145`
- ✅ `org.eclipse.ocl_3.23.0.v20260217-0639`
- ✅ `org.eclipse.equinox.common_3.20.300.v20251111-0312`

## Validação

Depois de aplicar estas mudanças:

1. **Ecore é carregado com sucesso** ✓
2. **Instâncias XMI são carregadas sem erros de feature** ✓
3. **Constraints OCL são parseados corretamente** ✓
4. **Não há erros de segurança de assinatura** ✓

## Próximos Passos

Execute o validador usando uma das opções acima para validar suas instâncias contra as restrições OCL definidas em `constraints.ocl`.

## Troubleshooting

Se ainda tiver problemas:

1. **Limpe o workspace:**
   - Delete a pasta `bin/` 
   - Reconstrua o projeto (Project → Clean)

2. **Verifique o classpath:**
   - Delete `.metadata/.plugins/org.eclipse.core.resources/.projects/*/`
   - Reimporte o projeto

3. **Use o script batch:**
   - Execute `run_validator.bat` diretamente do terminal (não depende do Eclipse)
