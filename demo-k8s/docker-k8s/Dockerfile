FROM openjdk:20-ea-15-slim-bullseye
RUN useradd --system demo && usermod -a -G demo demo
USER demo:demo
ARG JAR_FILE=build/libs/HelloWorld.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]