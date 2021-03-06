@echo off
rem #Dependencia con Lowagie IText 2.2.
call mvn install:install-file -Dfile=./com/lowagie/itext/2.2/itext-2.2.jar -DgroupId=com.lowagie -DartifactId=itext -Dversion=2.2 -Dpackaging=jar
rem #Dependencia con JavaX Activation 1.0.2
call mvn install:install-file -Dfile=./javax/activation/activation/1.0.2/activation-1.0.2.jar -DgroupId=javax.activation -DartifactId=activation -Dversion=1.0.2 -Dpackaging=jar -DpomFile=./javax/activation/activation/1.0.2/activation-1.0.2.pom
rem #Dependencia con Sun JaxWS STAX-EX 2.1.1
call mvn install:install-file -Dfile=./sun-jaxws/stax-ex/2.1.1/stax-ex-2.1.1.jar -DgroupId=sun-jaxws -DartifactId=stax-ex -Dversion=2.1.1 -Dpackaging=jar -DpomFile=./sun-jaxws/stax-ex/2.1.1/stax-ex-2.1.1.pom