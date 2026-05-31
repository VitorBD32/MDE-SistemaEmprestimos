@echo off
rem Batch para compilar e executar o gerador Java (M2M + M2T simplificado)
rem Execute a partir deste diretório ou duplo-clique no Windows Explorer

setlocal enabledelayedexpansion
cd /d "%~dp0"

echo === Gerador M2M+M2T (Generator.java) ===

if not exist src\Generator.java (
  echo Erro: src\Generator.java nao encontrado neste diretorio: %cd%
  exit /b 1
)

if not exist bin mkdir bin

echo Compilando Generator.java ...
javac -d bin src\Generator.java
if errorlevel 1 (
  echo Falha na compilacao. Verifique se o JDK esta instalado e o PATH configurado.
  exit /b 1
)

if not exist output mkdir output

echo Executando Generator ...
java -cp bin Generator
if errorlevel 1 (
  echo Erro durante a execucao do Generator.
  exit /b 1
)

echo Geracao concluida. Arquivos em: %cd%\output
echo - psm_model.json
echo - create_tables.sql

endlocal
exit /b 0
