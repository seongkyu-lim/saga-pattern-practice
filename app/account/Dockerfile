# Build stage
FROM gradle:8.10.2-jdk21-alpine AS build
WORKDIR /home/gradle/src

# Copy entire project to build this submodule
COPY . .

# Build only the account module's bootJar
RUN gradle --no-daemon clean :app:account:bootJar

# Runtime stage
FROM eclipse-temurin:21-jre-alpine
WORKDIR /app

# Copy the built jar from the build stage
COPY --from=build /home/gradle/src/app/account/build/libs/*.jar /app/app.jar

ENV JAVA_OPTS=""
EXPOSE 8081
ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar /app/app.jar"]
