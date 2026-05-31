@echo off
rem Template batch to run Eclipse headless to execute a launch group (/run_all.launch)
rem
rem USAGE:
rem   1) Set the path to your eclipse executable in the ECLIPSE_EXE variable below (or pass it as first argument)
rem   2) Set WORKSPACE to your workspace path (project root will be used here)
rem   3) Run the batch. It will start Eclipse pointing to the workspace and try to run the launch group.
rem
rem NOTE:
rem   - Running Eclipse in 100% headless mode to execute .launch groups depends on installed plugins and
rem     availability of a CLI application that dispatches launch configs. If this template doesn't run the
rem     launch group directly, it will start Eclipse with the workspace so you can then run the launch group
rem     or the included `run_all.launch` manually.

setlocal

rem Accept eclipse path as first arg or environment variable
if "%~1"=="" (
  if defined ECLIPSE_EXE (
    set "ECLIPSE=%ECLIPSE_EXE%"
  ) else (
    echo Erro: caminho para eclipse nao fornecido. Passe como parametro ou defina a variavel ECLIPSE_EXE.
    echo Exemplo: run_eclipse_headless_template.bat "C:\\apps\\eclipse\\eclipse.exe"
    exit /b 1
  )
) else (
  set "ECLIPSE=%~1"
)

rem Workspace (project root) - adjust if necessary
set "WORKSPACE=C:\Users\vitor\eclipse-workspace\MDE-SistemaEmprestimos-main"

echo Using Eclipse: %ECLIPSE%
echo Workspace: %WORKSPACE%

if not exist "%ECLIPSE%" (
  echo Erro: nao foi possivel encontrar o executavel do Eclipse em "%ECLIPSE%"
  exit /b 1
)

rem Start Eclipse pointing to the workspace. This will open the IDE (may show UI).
rem Many environments do not provide a reliable headless launcher for .launch groups; if you have
rem an Acceleo or ATL headless CLI installed, prefer to use those.

echo Iniciando Eclipse (isso pode abrir uma janela GUI) ...
start "EclipseLauncher" "%ECLIPSE%" -nosplash -data "%WORKSPACE%"

echo Se o Eclipse iniciar, abra a view Run Configurations e execute a Launch Group `run_all.launch` localizada em
echo seu projeto `SistemaEmprestimos_CIM` -> clique com direito sobre `run_all.launch` -> Run As -> Launch Group

endlocal
exit /b 0
