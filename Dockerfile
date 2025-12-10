# build stage
FROM eclipse-temurin:17-jdk-jammy AS build
WORKDIR /app
COPY gradlew .
COPY gradle gradle
COPY build.gradle.kts settings.gradle.kts ./
RUN chmod +x ./gradlew
COPY . .
RUN ./gradlew clean bootJar -x test

# runtime stage
FROM eclipse-temurin:17-jre-jammy
WORKDIR /app
COPY --from=build /app/build/libs/*.jar app.jar

# default for local development (override in cloud)
ENV SPRING_KAFKA_BOOTSTRAP_SERVERS=localhost:9092
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app/app.jar"]
