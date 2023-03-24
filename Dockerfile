FROM openjdk:8
COPY ./target/calculator_using_devops-1.0-SNAPSHOT-jar-with-dependencies.jar ./
WORKDIR ./
CMD ["java", "-jar", "calculator_using_devops-1.0-SNAPSHOT-jar-with-dependencies.jar"]
