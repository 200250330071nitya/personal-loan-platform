FROM eclipse-temurin:17-jre

WORKDIR /app

COPY target/loan-service-1.0.0.jar loan-service.jar

EXPOSE 8080

ENTRYPOINT ["java","-jar","loan-service.jar"]


