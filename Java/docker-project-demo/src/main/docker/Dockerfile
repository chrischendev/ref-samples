FROM openjdk:8-jdk-alpine
VOLUME /tmp
ADD docker-project-demo.jar app.jar
EXPOSE 5061
ENTRYPOINT ["java","-jar","/app.jar"]