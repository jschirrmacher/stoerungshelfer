FROM openjdk:17-jdk as build
WORKDIR /app
ADD . /app/
RUN ./mvnw clean install -DskipTests=true

FROM openjdk:17-jdk
WORKDIR /app
COPY --from=build /app/target/*.jar ./
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -jar /app/*.jar"]
