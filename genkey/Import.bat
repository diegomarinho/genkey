@ECHO OFF

title GenKey - MV Sistemas

echo Using the keytool to import a certificate

REM %1 - Alias/Apelido
REM	%2 - Caminho arquivo keystore
REM	%3 - Senha de autenticação
REM	%4 - Caminho arquivo cer - Chave Pública

"C:/Program Files (x86)/Java/jdk1.6.0_45/bin/keytool" -import -alias %1 -keystore %2 -storepass %3 -file %4

pause