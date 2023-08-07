#
# Build stage
#
FROM maven:3.8.3-openjdk-17 AS build
COPY java-api/bonds_mgmt_backend /home/app/java-api/
RUN mvn -f /home/app/java-api/pom.xml clean package

#
# Package stage
#
FROM openjdk:17.0.1-jdk-slim
COPY --from=build /home/app/java-api/target/bonds_mgmt_backend-0.0.1-SNAPSHOT.jar /usr/local/lib/WebApp.jar
EXPOSE 8080 
ENTRYPOINT ["java", "-jar", "/usr/local/lib/WebApp.jar","--spring.profiles.active=prod"]