#!/usr/bin/env bash
TOMCAT_HOME=/Users/lanxu/work/apache-tomcat/lanxu.com
mvn clean & mvn install
mv target/lanxu-springmvc.war ${TOMCAT_HOME}/webapps/
cd ${TOMCAT_HOME}/bin
cd ${TOMCAT_HOME}/webapps/
unzip -o lanxu-springmvc.war
rm lanxu-springmvc.war
sh ${TOMCAT_HOME}/bin/restart.sh
