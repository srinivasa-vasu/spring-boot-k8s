FROM openjdk:11.0-jre-slim
WORKDIR application
ARG JAR_FILE=./build/libs/kloudnative-*.jar
COPY ${JAR_FILE} application.jar
ENTRYPOINT [ "java", "-jar", "application.jar" ]

#FROM openjdk:11.0-jdk-slim as builder
#WORKDIR source
#ARG JAR_FILE=./build/libs/kloudnative-*.jar
#COPY ${JAR_FILE} application.jar
#RUN jar -xf ./application.jar

#FROM openjdk:11.0-jre-slim
#WORKDIR application
#COPY --from=builder source/BOOT-INF/lib lib
#COPY --from=builder source/META-INF app/META-INF
#COPY --from=builder source/BOOT-INF/classes app
#ENTRYPOINT [ "java", "-cp", "app:lib/*", "io.humourmind.kloudnative.KloudNativeApplication" ]

#FROM openjdk:11.0-jdk-slim as builder
#WORKDIR source
#ARG JAR_FILE=./build/libs/kloudnative-*.jar
#COPY ${JAR_FILE} application.jar
#RUN jar -xf ./application.jar

#FROM openjdk:11.0-jre-slim
#WORKDIR application
#COPY --from=builder source/BOOT-INF/lib BOOT-INF/lib
#COPY --from=builder source/BOOT-INF/classpath.idx BOOT-INF/
#COPY --from=builder source/BOOT-INF/layers.idx BOOT-INF/
#COPY --from=builder source/org org/
#COPY --from=builder source/META-INF META-INF
#COPY --from=builder source/BOOT-INF/classes BOOT-INF/classes
#ENTRYPOINT [ "java", "org.springframework.boot.loader.JarLauncher" ]

#FROM openjdk:11.0-jdk-slim as builder
#WORKDIR source
#ARG JAR_FILE=./build/libs/kloudnative-*.jar
#COPY ${JAR_FILE} application.jar
#RUN java -Djarmode=layertools -jar ./application.jar extract

#FROM openjdk:11.0-jre-slim
#WORKDIR application
#COPY --from=builder source/dependencies/ ./
#COPY --from=builder source/spring-boot-loader/ ./
#COPY --from=builder source/snapshot-dependencies/ ./
#COPY --from=builder source/application/ ./
#ENTRYPOINT [ "java", "org.springframework.boot.loader.JarLauncher" ]
