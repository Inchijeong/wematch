FROM azul/zulu-openjdk-alpine:11 as packager
ARG JAR_FILE=build/libs/*.jar
COPY run.sh .
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]