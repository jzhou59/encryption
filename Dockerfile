# syntax=docker/dockerfile:1

FROM openjdk:17 as base

WORKDIR /encryption

COPY .mvn ./.mvn

COPY mvnw pom.xml ./

RUN ./mvnw dependency:go-offline

COPY src ./src

FROM base as test
RUN [ "./mvnw", "test"]

FROM base as development
CMD ["./mvnw", "spring-boot:run"]