FROM eclipse-temurin
LABEL maintainer="lucasaita.dev"
WORKDIR /app
COPY target/AluguelDeCarros-0.0.1-SNAPSHOT.jar /app/treinando-docker.jar
ENTRYPOINT ["java", "-jar", "treinando-docker.jar"]