#!/usr/bin/env python3
"""
Compilador para o projeto HeadlessOCLValidator
Reconstrói as classes Java com as dependências corretas
"""

import os
import subprocess
import sys

PROJECT_DIR = os.path.dirname(os.path.abspath(__file__))
PLUGINS_DIR = r"C:\Users\vitor\.p2\pool\plugins"
BIN_DIR = os.path.join(PROJECT_DIR, "bin")

# Certificar de que o diretório bin existe
os.makedirs(BIN_DIR, exist_ok=True)

# Lista de JARs necessários (apenas versões NOVAS)
JARS = [
    os.path.join(PLUGINS_DIR, "org.eclipse.emf.ecore_2.42.0.v20251210-1145.jar"),
    os.path.join(PLUGINS_DIR, "org.eclipse.emf.common_2.31.0.v20251210-1145.jar"),
    os.path.join(PLUGINS_DIR, "org.eclipse.emf.ecore.xmi_2.40.0.v20251210-1145.jar"),
    os.path.join(PLUGINS_DIR, "org.eclipse.ocl_3.23.0.v20260217-0639.jar"),
    os.path.join(PLUGINS_DIR, "org.eclipse.ocl.common_1.23.0.v20260217-0639.jar"),
    os.path.join(PLUGINS_DIR, "org.eclipse.ocl.ecore_3.23.0.v20260217-0639.jar"),
    os.path.join(PLUGINS_DIR, "org.eclipse.ocl.pivot_1.23.0.v20260217-0639.jar"),
]

# Construir classpath
classpath = ";".join(JARS)

# Lista de arquivos Java a compilar
java_files = [
    "src/tools/HeadlessOCLValidator.java",
    "src/sistema_emprestimo/Emprestimo.java",
    "src/sistema_emprestimo/Equipamento.java",
    "src/sistema_emprestimo/Professor.java",
    "src/sistema_emprestimo/Sistema_emprestimoFactory.java",
    "src/sistema_emprestimo/Sistema_emprestimoPackage.java",
    "src/sistema_emprestimo/impl/EmprestimoImpl.java",
    "src/sistema_emprestimo/impl/EquipamentoImpl.java",
    "src/sistema_emprestimo/impl/ProfessorImpl.java",
    "src/sistema_emprestimo/impl/Sistema_emprestimoFactoryImpl.java",
    "src/sistema_emprestimo/impl/Sistema_emprestimoPackageImpl.java",
    "src/sistema_emprestimo/util/Sistema_emprestimoAdapterFactory.java",
    "src/sistema_emprestimo/util/Sistema_emprestimoSwitch.java",
    "src/sistema_emprestimo/validation/EmprestimoValidator.java",
    "src/sistema_emprestimo/validation/EquipamentoValidator.java",
    "src/sistema_emprestimo/validation/ProfessorValidator.java",
]

# Converter para caminhos absolutos
java_files = [os.path.join(PROJECT_DIR, f) for f in java_files]

print("=" * 50)
print("Compilando projeto HeadlessOCLValidator")
print("=" * 50)
print(f"Projeto: {PROJECT_DIR}")
print(f"Destino: {BIN_DIR}")
print()

# Executar javac
cmd = ["javac", "-encoding", "UTF-8", "-cp", classpath, "-d", BIN_DIR] + java_files

try:
    result = subprocess.run(cmd, cwd=PROJECT_DIR, capture_output=True, text=True)
    
    if result.returncode == 0:
        print("✅ Compilação bem-sucedida!")
        print()
        print("Próximos passos:")
        print("1. Execute: run_ocl_validator.bat")
        print()
    else:
        print("❌ Erro na compilação:")
        print(result.stderr)
        sys.exit(1)
        
except Exception as e:
    print(f"❌ Erro: {e}")
    sys.exit(1)
