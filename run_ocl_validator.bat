@echo off
REM Script para executar o Headless OCL Validator evitando conflitos de versão

setlocal enabledelayedexpansion

set PROJECT_DIR=%~dp0
set PLUGINS_DIR=C:\Users\vitor\.p2\pool\plugins

REM Construir classpath apenas com versões NOVAS e compatíveis
REM Importante: Usar APENAS uma versão de cada JAR
set CLASSPATH=%PROJECT_DIR%bin

REM Core EMF - APENAS versão 2.42.0 (mais nova)
set CLASSPATH=!CLASSPATH!;%PLUGINS_DIR%\org.eclipse.emf.ecore_2.42.0.v20251210-1145.jar
set CLASSPATH=!CLASSPATH!;%PLUGINS_DIR%\org.eclipse.emf.common_2.31.0.v20251210-1145.jar
set CLASSPATH=!CLASSPATH!;%PLUGINS_DIR%\org.eclipse.emf.ecore.xmi_2.40.0.v20251210-1145.jar

REM OCL - APENAS versão 3.23.0
set CLASSPATH=!CLASSPATH!;%PLUGINS_DIR%\org.eclipse.ocl_3.23.0.v20260217-0639.jar
set CLASSPATH=!CLASSPATH!;%PLUGINS_DIR%\org.eclipse.ocl.common_1.23.0.v20260217-0639.jar
set CLASSPATH=!CLASSPATH!;%PLUGINS_DIR%\org.eclipse.ocl.ecore_3.23.0.v20260217-0639.jar
set CLASSPATH=!CLASSPATH!;%PLUGINS_DIR%\org.eclipse.ocl.pivot_1.23.0.v20260217-0639.jar

cd /d "%PROJECT_DIR%"

echo.
echo ====================================
echo Executando Headless OCL Validator
echo ====================================
echo Projeto: %PROJECT_DIR%
echo.

REM Executar com várias estratégias para evitar conflitos de segurança
java -Xmx512m ^
  -Dorg.eclipse.emf.ecore.plugin.EcorePlugin.noSplash=true ^
  -Dorg.osgi.framework.bundle.parent=ext ^
  -XX:+IgnoreUnrecognizedVMOptions ^
  -cp "!CLASSPATH!" ^
  tools.HeadlessOCLValidator

if errorlevel 1 (
    echo.
    echo ERRO: Falha ao executar o validador
    echo.
    echo Se receber erro de assinatura de JARs, tente:
    echo 1. Limpar o cache: rm -rf %PLUGINS_DIR%\.metadata
    echo 2. Reinstalar Eclipse com versões atualizadas
    echo 3. Usar apenas os JARs mais recentes
    pause
) else (
    echo.
    echo Validacao completada com sucesso!
    echo.
)

endlocal
