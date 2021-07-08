FROM openjdk:11-jre-slim

WORKDIR home

COPY target/simple-storage-*.jar app.jar

ENTRYPOINT java -jar app.jar

