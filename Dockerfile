FROM openjdk:11-jre-slim
MAINTAINER dev.shadmanahmed
COPY target/foodfinder-0.0.1-SNAPSHOT.jar message-server-1.0.0.jar
ENTRYPOINT ["java","-jar","/message-server-1.0.0.jar"]