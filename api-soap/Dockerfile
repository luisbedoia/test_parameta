# Construye el servicio SOAP como módulo independiente
FROM maven:3.9.9-eclipse-temurin-21 AS build
WORKDIR /workspace
COPY pom.xml ./
COPY api-rest/pom.xml api-rest/pom.xml
COPY api-soap/pom.xml api-soap/pom.xml
COPY api-soap/src api-soap/src
RUN mvn -pl api-soap -am -B -DskipTests package

FROM eclipse-temurin:21-jre
WORKDIR /app
COPY --from=build /workspace/api-soap/target/api-soap-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8081
ENTRYPOINT ["java","-jar","/app/app.jar"]
