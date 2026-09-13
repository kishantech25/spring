# Multi-stage build for Spring Boot with JDK 21
# Stage 1: Build
FROM maven:3.9-eclipse-temurin-21 AS builder

WORKDIR /app

# Copy pom.xml and source code
COPY pom.xml .
COPY src ./src

# Build the application
RUN mvn clean package -DskipTests

# Stage 2: Runtime
FROM eclipse-temurin:21-jre-alpine

WORKDIR /app

# Copy built JAR from builder stage
COPY --from=builder /app/target/*.jar app.jar

# Expose port
EXPOSE 8081

# Health check
HEALTHCHECK --interval=30s --timeout=3s --start-period=5s --retries=3 \
    CMD wget --no-verbose --tries=1 --spider http://localhost:8081/api/actuator/health || exit 1

# Run application
ENTRYPOINT ["java", "-jar", "app.jar"]
