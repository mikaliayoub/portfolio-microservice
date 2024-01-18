# Use the AdoptOpenJDK 17 with HotSpot image as the base image
FROM adoptopenjdk:17-jre-hotspot

# Set the working directory inside the container
WORKDIR /app

# Copy the Maven target directory into the container
COPY target/server_eureka-*.jar server_eureka.jar

# Expose the default Eureka server port
EXPOSE 8761

# Command to run the application
CMD ["java", "-jar", "server_eureka.jar"]

