#!/bin/bash

file=$1

if [[ ${file: -5} == ".html" ]]; then
	echo "copying ${file} to /ROOT/Servlets..."
	cp ${file} /opt/tomcat/apache-tomcat-9.0.17/webapps/ROOT/Servlets
elif [[ ${file: -6} == ".class" ]]; then
	echo "copying ${file} to /ROOT/WEB-INF/classes..."
	cp ${file} /opt/tomcat/apache-tomcat-9.0.17/webapps/ROOT/WEB-INF/classes
fi
