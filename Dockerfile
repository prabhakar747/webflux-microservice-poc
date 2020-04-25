# For Java 8, try this
FROM openjdk:8-jdk-alpine

# Refer to Maven build -> finalName
ARG JAR_FILE=/target/webflux-microservice-poc.jar

# cd /opt/app
WORKDIR /opt/app

# cp target/spring-boot-web.jar /opt/app/app.jar
COPY ${JAR_FILE} app.jar

# java -jar /opt/app/app.jar
ENTRYPOINT ["java","-jar","app.jar"]

## sudo docker run -p 8080:8080 -t docker-spring-boot:1.0