JavaApp

This app is a backbase assignment.

Getting Started

Clone the project in git hub, run maven clean install, deploy in Apache Tomcat. Access http://localhost:8080/javaapp/, to accessthe restricted area please use, user:bruno password:hireme.  

Prerequisites

- Internet access.
- Apache Tomcat 7.
- Maven 3.5.0.
- Java 1.8.0_144.

Installing

Download Apache Tomcat from Apache website, install Apache Tomcat 7 with the default configuration.
Download JDK 1.8.0_144, configure JAVA_HOME environment variable.
Download Apache Maven 3.5.0, configure MAVEN_HOME environment variable with the default configuration, just make sure that you can access internet to download project dependencies in some cases will be necessary configura proxy settings. 

If you have Git installed, just clone the repo with command.
git clone https://github.com/brunoneofiti/javaapp

If you don't have Git, download it from https://github.com/brunoneofiti/javaapp.

Access the JavaApp folder, execute command.
mvn clean install

Copy {APP_INSTALL_FOLDER}/targe/javaapp.war to {TOMCAT_HOME}/webapps/

Run Apache Tomcat 7 in Windows: {TOMCAT_HOME}/bin/catalina.bat start 
Run Apache Tomcat 7 in Linux: {TOMCAT_HOME}/bin/catalina.sh start

Access with your browser: http://localhost:8080/javaapp/.

Built With

Spring framework - 4.3.11.RELEASE
Spring security - 4.2.3.RELEASE
Jackson - 2.6.3 
Jstl - 1.2
Servlet - 3.0.1
JUnit - 3.8.1
Apache.camel - 2.19.3
