JavaApp

Backbase assigment

Getting Started

Clone the project in git hub, run maven clean install, deploy in Apache Tomcat. Access http://localhost:8080/javaapp/, restricted area user:bruno password:hireme.  

Prerequisites

- Internet access
- Apache Tomcat 7
- Maven 3.5.0 
- Java 1.8.0_144

Installing

Download Apache Tomcat from Apache website, install Apache Tomcat 7 with the default configuration.
Download JDK 1.8.0_144, configure JAVA_HOME environment variable.
Download Apache Maven 3.5.0, configure MAVEN_HOME environment variable with the default configuration, just make sure that you can access internet to download project dependencies in some cases will be necessary configura proxy settings. 

If you have Git installed, just clone the repo with command
git clone https://github.com/brunoneofiti/javaapp

If you don't have Git, download it from https://github.com/brunoneofiti/javaapp.

Access the JavaApp folder, execute command
mvn clean install

Copy {APP_INSTALL_FOLDER}/targe/javaapp.war to {TOMCAT_HOME}/webapps/

Run Apache Tomcat 7 in Windows: {TOMCAT_HOME}/bin/catalina.bat start 
Run Apache Tomcat 7 in Linux: {TOMCAT_HOME}/bin/catalina.sh start

Access with your browser: http://localhost:8080/javaapp/

Running the tests

Explain how to run the automated tests for this system


Built With

Spring framework - 4.3.11.RELEASE
Spring security - 4.2.3.RELEASE
Jackson - 2.6.3 
Jstl - 1.2
Servlet - 3.0.1
JUnit - 3.8.1
Apache.camel - 2.19.3


Overview

1 - Create a Java web application based on the standard servlet spec
http://localhost:8080/javaapp/index.jsp

2 - The web application should provide a REST api to create a list of ING ATMs in a given Dutch city and return a well formed JSON response 
http://localhost:8080/javaapp/

3 - The web application should invoke an external service to gather a super set of the data:  https://www.ing.nl/api/locator/atms/
http://localhost:8080/javaapp/ws/

4 - Create a page that shows the list of ING ATMs
http://localhost:8080/javaapp/ws/

5 - Use Spring and Maven. (check pom.xml)

6 - Secure the page with Spring security
If you try one of the bellow pages not logeged in, the app will send you to login page http://localhost:8080/javaapp/login
http://localhost:8080/javaapp/restricted/  
http://localhost:8080/javaapp/ws/getCity

7 - Unit tests using jUnit

