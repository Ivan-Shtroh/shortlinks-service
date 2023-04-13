FROM amazoncorretto:11.0.8
ARG JAR_FILE=*.jar
COPY ${JAR_FILE} shortlinks.jar
ENTRYPOINT ["java", "-jar", "shortlinks.jar"]
COPY . ./app