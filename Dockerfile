FROM amazoncorretto:11
MAINTAINER dev.shadmanahmed
COPY target/foodfinder-1.0.0.jar foodfinder-1.0.0.jar
ENTRYPOINT ["java","-jar","/foodfinder-1.0.0.jar"]