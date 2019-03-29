# servlets
examples with web.xml and annotation

### maven war-plugin reference
https://maven.apache.org/plugins/maven-war-plugin/examples/adding-filtering-webresources.html

### docker commands for servletexamle-annotation application
servletexamle-annotation? docker build -t web-app-tomcat -f .\docker\Dockerfile .

servletexamle-annotation? docker container run -p 9090:8080 web-app-tomcat

