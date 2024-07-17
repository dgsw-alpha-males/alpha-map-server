FROM openjdk:latest

COPY ./build/libs/alpha-map-server-0.0.1-SNAPSHOT.jar /app/app.jar

ENTRYPOINT ["java", "-jar", "/app/app.jar"]
