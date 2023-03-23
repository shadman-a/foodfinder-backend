FROM openjdk:11-jre-slim
MAINTAINER dev.shadmanahmed
#COPY ./target/foodfinder-0.0.1-SNAPSHOT.jar foodfinder-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/foodfinder-0.0.1-SNAPSHOT.jar"]