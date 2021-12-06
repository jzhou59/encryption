FROM openjdk:17

WORKDIR /encryption

COPY .mvn/ .mvn

COPY mvnw pom.xml ./

COPY src ./src

COPY README.md README.md

CMD ["./mvnw", "spring-boot:run"]