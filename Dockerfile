# Use OpenJDK 17
FROM eclipse-temurin:17-jdk

# Set working directory inside container
WORKDIR /app

# Copy the built jar into container
COPY target/Medical-0.0.1-SNAPSHOT.jar app.jar

# Expose port your Spring Boot app runs on
EXPOSE 8181

# Run the jar
ENTRYPOINT ["java","-jar","app.jar"]
