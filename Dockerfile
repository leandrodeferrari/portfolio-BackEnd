FROM openjdk:17-jdk-slim
MAINTAINER leandrodeferrari
COPY /target/backend-1.0.0.jar portfolio.jar
ENTRYPOINT ["java", "-jar", "/portfolio.jar"]