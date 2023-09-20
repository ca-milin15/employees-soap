FROM openjdk:17-alpine
COPY build/libs/employee-0.0.2-SNAPSHOT.jar employee-0.0.2-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","employee-0.0.2-SNAPSHOT.jar"]
