FROM amazoncorretto:11-alpine
WORKDIR app
COPY build.gradle .
COPY gradle gradle
COPY gradlew .
RUN ls
RUN ./gradlew build
COPY . .
RUN ls
RUN ./gradlew build
FROM amazoncorretto:11-alpine
COPY --from=0 /build/libs/who-wants-to-be-a-millionaire-0.1.jar app.jar
EXPOSE 9876
ENTRYPOINT ["java","-jar","/app.jar"]
