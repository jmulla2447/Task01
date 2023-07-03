FROM openjdk:17
LABEL authors="javedmulla"
ADD target/okapi-camera-docker.jar okapi-camera-docker.jar
ENTRYPOINT ["java", "-jar", "okapi-camera-docker.jar"]
