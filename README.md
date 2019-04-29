# servlets
examples using
a> web.xml
b> annotation

### maven war-plugin reference
https://maven.apache.org/plugins/maven-war-plugin/examples/adding-filtering-webresources.html

### docker commands for servletexamle-annotation application

#### Option-1: Using a docker file
servletexamle-annotation# docker build -t web-app-tomcat -f .\docker\Dockerfile .

servletexamle-annotation# docker container run -p 9090:8080 web-app-tomcat


#### Option-2: Using docker-compose
servletexamle-annotation# docker-compose up

