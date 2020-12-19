FROM public.ecr.aws/w1m2m2a3/amazoncorretto:11 AS builder
WORKDIR /app
COPY gradle gradle
COPY gradlew .
RUN ./gradlew --version
COPY grailsw .
COPY grails-wrapper.jar .
COPY build.gradle .
COPY gradle.properties .
RUN ./grailsw --version
COPY . .
RUN ./grailsw assemble --no-daemon
RUN ./grailsw test-app --no-daemon
RUN ls build/libs/
FROM public.ecr.aws/w1m2m2a3/amazoncorretto:11
COPY --from=builder /app/build/libs/app-0.1.jar app.jar
EXPOSE 80
ENTRYPOINT ["java","-jar","app.jar"]
