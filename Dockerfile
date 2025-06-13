# Base image with Maven + Java 17
FROM maven:3.9.6-eclipse-temurin-21

# Define working directory
WORKDIR /app

# Copy everything into the container
COPY . .

# Build the entire multi-module project
RUN mvn clean package -DskipTests

# Set environment variable
ENV MONGODB_URI=""

# Run the JAR from the infrastructure module
CMD ["java", "-jar", "infrastructure/target/g12-infrastructure-0.0.1-SNAPSHOT.jar"]