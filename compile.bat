@echo off
REM Script para compilar o projeto com classpath correto

setlocal enabledelayedexpansion

set PROJECT_DIR=%~dp0
set PLUGINS_DIR=C:\Users\vitor\.p2\pool\plugins

REM Construir classpath com TODAS as dependências necessárias
REM EMF Core
set CLASSPATH=%PLUGINS_DIR%\org.eclipse.emf.ecore_2.42.0.v20251210-1145.jar
set CLASSPATH=!CLASSPATH!;%PLUGINS_DIR%\org.eclipse.emf.common_2.31.0.v20251210-1145.jar
set CLASSPATH=!CLASSPATH!;%PLUGINS_DIR%\org.eclipse.emf.ecore.xmi_2.40.0.v20251210-1145.jar

REM OCL
set CLASSPATH=!CLASSPATH!;%PLUGINS_DIR%\org.eclipse.ocl_3.23.0.v20260217-0639.jar
set CLASSPATH=!CLASSPATH!;%PLUGINS_DIR%\org.eclipse.ocl.common_1.23.0.v20260217-0639.jar
set CLASSPATH=!CLASSPATH!;%PLUGINS_DIR%\org.eclipse.ocl.ecore_3.23.0.v20260217-0639.jar
set CLASSPATH=!CLASSPATH!;%PLUGINS_DIR%\org.eclipse.ocl.pivot_1.23.0.v20260217-0639.jar

cd /d "%PROJECT_DIR%"

echo.
echo ====================================
echo Compilando projeto...
echo ====================================
echo.

REM Criar diretório bin se não existir
if not exist "bin" mkdir bin

REM Compilar todos os arquivos Java
javac -encoding UTF-8 -cp "!CLASSPATH!" -d bin ^
  src\tools\HeadlessOCLValidator.java ^
  src\sistema_emprestimo\Emprestimo.java ^
  src\sistema_emprestimo\Equipamento.java ^
  src\sistema_emprestimo\Professor.java ^
  src\sistema_emprestimo\Sistema_emprestimoFactory.java ^
  src\sistema_emprestimo\Sistema_emprestimoPackage.java ^
  src\sistema_emprestimo\impl\EmprestimoImpl.java ^
  src\sistema_emprestimo\impl\EquipamentoImpl.java ^
  src\sistema_emprestimo\impl\ProfessorImpl.java ^
  src\sistema_emprestimo\impl\Sistema_emprestimoFactoryImpl.java ^
  src\sistema_emprestimo\impl\Sistema_emprestimoPackageImpl.java ^
  src\sistema_emprestimo\util\Sistema_emprestimoAdapterFactory.java ^
  src\sistema_emprestimo\util\Sistema_emprestimoSwitch.java ^
  src\sistema_emprestimo\validation\EmprestimoValidator.java ^
  src\sistema_emprestimo\validation\EquipamentoValidator.java ^
  src\sistema_emprestimo\validation\ProfessorValidator.java

if errorlevel 1 (
    echo.
    echo ERRO: Falha na compilacao!
    pause
    exit /b 1
) else (
    echo.
    echo Compilacao completada com sucesso!
    echo.
    echo Agora execute: run_ocl_validator.bat
    echo.
    pause
)

endlocal
