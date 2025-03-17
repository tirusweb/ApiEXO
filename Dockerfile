# Stage 1: Build Maven project
FROM maven:3-openjdk-17 AS build
WORKDIR /app

COPY pom.xml .
RUN mvn dependency:go-offline # Tải trước dependencies

COPY . .
RUN mvn clean package -DskipTests

# Stage 2: Run application
FROM openjdk:17-jdk-slim
WORKDIR /app

COPY --from=build /app/target/DrComputer-0.0.1-SNAPSHOT.war drcomputer.war
EXPOSE 8080 

ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "drcomputer.war"]
