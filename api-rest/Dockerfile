# Construye el servicio REST como módulo independiente
FROM maven:3.9.9-eclipse-temurin-21 AS build
WORKDIR /workspace
COPY pom.xml ./
COPY api-rest/pom.xml api-rest/pom.xml
COPY api-soap/pom.xml api-soap/pom.xml
COPY api-rest/src api-rest/src
RUN mvn -pl api-rest -am -B -DskipTests package

FROM eclipse-temurin:21-jre
WORKDIR /app
COPY --from=build /workspace/api-rest/target/api-rest-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app/app.jar"]
