#Docker base image : Alpine Linux with OpenJDK JRE
FROM openjdk:8-jre-alpine
#Check the java version
RUN ["java", "-version"]

RUN mkdir /app

COPY */demo-0.0.1-SNAPSHOT.jar /app/demo-0.0.1-SNAPSHOT.jar

#Port the container listens on
EXPOSE 8081
#CMD to be executed when docker is run.
ENTRYPOINT ["java","-jar","app/demo-0.0.1-SNAPSHOT.jar"]
