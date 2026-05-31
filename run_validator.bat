@echo off
REM Script para executar o Headless OCL Validator com classpath limpo
REM Evita conflitos de assinatura de JARs

setlocal enabledelayedexpansion

REM Define o diretório do projeto
set PROJECT_DIR=%~dp0

REM Define o diretório de plugins do Eclipse
set PLUGINS_DIR=C:\Users\vitor\.p2\pool\plugins

REM Constrói o classpath com versões específicas
set CLASSPATH=%PROJECT_DIR%bin

REM EMF Core (versão mais recente)
set CLASSPATH=!CLASSPATH!;%PLUGINS_DIR%\org.eclipse.emf.ecore_2.42.0.v20251210-11455.jar
set CLASSPATH=!CLASSPATH!;%PLUGINS_DIR%\org.eclipse.emf.common_2.31.0.v20251210-11455.jar
set CLASSPATH=!CLASSPATH!;%PLUGINS_DIR%\org.eclipse.emf.ecore.xmi_2.40.0.v20251210-1145.jar

REM OCL
set CLASSPATH=!CLASSPATH!;%PLUGINS_DIR%\org.eclipse.ocl_3.23.0.v20260217-0639.jar
set CLASSPATH=!CLASSPATH!;%PLUGINS_DIR%\org.eclipse.ocl.common_1.23.0.v20260217-0639.jar
set CLASSPATH=!CLASSPATH!;%PLUGINS_DIR%\org.eclipse.ocl.ecore_3.23.0.v20260217-0639.jar
set CLASSPATH=!CLASSPATH!;%PLUGINS_DIR%\org.eclipse.ocl.pivot_1.23.0.v20260217-0639.jar

REM Equinox OSGi
set CLASSPATH=!CLASSPATH!;%PLUGINS_DIR%\org.eclipse.osgi_3.24.100.v20251215-1416.jar
set CLASSPATH=!CLASSPATH!;%PLUGINS_DIR%\org.eclipse.equinox.common_3.20.300.v20251111-0312.jar

REM Execute o validador
cd /d "%PROJECT_DIR%"
echo Running Headless OCL Validator from %PROJECT_DIR%
echo.

java -Xmx512m ^
  -Dorg.osgi.framework.bundle.parent=boot ^
  -Dorg.eclipse.emf.ecore.plugin.EcorePlugin.noSplash=true ^
  -cp "!CLASSPATH!" ^
  tools.HeadlessOCLValidator

endlocal
pause
