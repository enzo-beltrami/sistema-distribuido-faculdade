FROM openjdk:11
COPY target/checkout-*-SNAPSHOT.jar /usr/src/app.jar
WORKDIR /usr/src/
CMD ["java", "-jar", "app.jar"]