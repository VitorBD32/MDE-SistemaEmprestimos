@echo off
REM Script para compilar e executar o gerador (Windows cmd.exe)
cd /d "%~dp0"
if not exist src goto no_src
if not exist instances goto no_instances
if not exist output mkdir output
echo Compilando...
javac -d . src\Generator.java
if errorlevel 1 (
  echo Erro de compilacao
  pause
  goto end
)
echo Executando gerador...
java Generator
echo FIM
goto end

:no_src
echo Diretorio src/ nao encontrado. Execute este script a partir de generator\
goto end

:no_instances
echo Diretorio instances/ nao encontrado. Copie os XMI para generator\\instances
goto end

:end
