#For building a full gradle docker is needed becasue grails has some quirks.
# the docker file is organized in a way so that build dependencies are cached.
FROM amazoncorretto:11-alpine AS builder
WORKDIR /app
COPY gradle gradle
COPY gradlew .
RUN ./gradlew --version
COPY grailsw .
COPY grails-wrapper.jar .
COPY build.gradle .
COPY gradle.properties .
RUN apk update && apk add bash
RUN ./grailsw --version
COPY . .
RUN ./grailsw assemble --no-daemon
RUN ./gradlew test --no-daemon
RUN ls build/libs/
FROM amazoncorretto:11-alpine
COPY --from=builder /app/build/libs/app-0.1.jar app.jar
EXPOSE 9876
ENTRYPOINT ["java","-jar","app.jar"]
