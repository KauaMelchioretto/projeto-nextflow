# Build Springboot application (multi-stage build)
FROM maven:3.9.10-eclipse-temurin-21 AS build
WORKDIR /app

COPY pom.xml .
COPY src/ ./src

RUN mvn clean package

# Create runtime image
FROM openjdk:21-jdk-slim
COPY --from=build /app/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]