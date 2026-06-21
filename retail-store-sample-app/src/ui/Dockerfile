# This Dockerfile must be built from the root directory of the repository
# Command: docker build -f src/ui/Dockerfile -t ui-service .
FROM maven:3.9-eclipse-temurin-21 AS builder
WORKDIR /workspace
# Copy the entire src directory to have access to openapi.yml files of other services
COPY src ./src
WORKDIR /workspace/src/ui
# Build without tests and skip checkstyle
RUN mvn clean package -DskipTests -Dcheckstyle.skip=true

FROM eclipse-temurin:21-jre-alpine
WORKDIR /app
COPY --from=builder /workspace/src/ui/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
