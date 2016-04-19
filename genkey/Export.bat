@ECHO OFF

title GenKey - MV Sistemas

echo This will import an X.509 SSL certificate into the keystore for the JVM specified

REM %1 - Caminho keystore (*.PFX)
REM	%2 - Senha storepass
REM	%3 - Caminho arquivo temp_dados_cert.txt

"C:/Program Files (x86)/Java/jdk1.6.0_45/bin/keytool" -v -list -storetype pkcs12 -keystore %2 -storepass %3 > %4

pause