FROM humourmind/adoptjre:11.0.7

LABEL MAINTAINER="Srinivasa Vasu"

ENV SPRING_OUTPUT_ANSI_ENABLED=ALWAYS 

EXPOSE 8080

COPY ./build/libs/kloudnative-1.0.jar app.jar

ENTRYPOINT ["java", "-jar", "/app.jar", "${JAVA_OPTS}", "-Djava.security.egd=file:/dev/./urandom"]
