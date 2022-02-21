FROM amazoncorretto:11
COPY /build/libs/demospringbootkube-*.jar demospringbootkube.jar
ENTRYPOINT ["java", "-jar", "demospringbootkube.jar"]
