FROM openjdk:17
LABEL authors="javedmulla"
ADD target/okapi-camera-docker.jar camera_image.jar
ENTRYPOINT ["java", "-jar", "camera_image.jar"]
