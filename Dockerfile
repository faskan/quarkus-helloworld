FROM openjdk:8-jdk-alpine
# RUN apk add --no-cache bash

# Configure the JAVA_OPTIONS, you can add -XshowSettings:vm to also display the heap size.
ENV JAVA_OPTIONS="-Dquarkus.http.host=0.0.0.0 -Djava.util.logging.manager=org.jboss.logmanager.LogManager"

COPY scripts/run-java.sh /run-java.sh

COPY target/lib/* /lib/
COPY target/*-runner.jar app.jar

EXPOSE 8080
ENTRYPOINT [ "/run-java.sh" ]