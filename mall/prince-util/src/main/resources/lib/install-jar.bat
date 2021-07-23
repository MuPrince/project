@echo off
REM 安装所需的jar包到本地maven库
setlocal
set currentPath=%~dp0%
set currentPath=%currentPath:~0,-1%
set ojdbc6=%currentPath%\ojdbc6.jar
set chardet=%currentPath%\chardet.jar

rem 调用mvn命令将jar安装到本地maven仓库
call mvn install:install-file -Dfile=%ojdbc6% -DgroupId=com.oracle -DartifactId=ojdbc6 -Dversion=11.2.0 -Dpackaging=jar
echo .
echo .
call mvn install:install-file -Dfile=%chardet% -DgroupId=org.mozilla.intl -DartifactId=chardet -Dversion=1.0 -Dpackaging=jar
echo .
echo .

echo install finished.
pause
