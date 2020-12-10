FROM amazoncorretto:11-alpine

COPY build/libs/who-wants-to-be-a-millionaire-0.1.jar app.jar
EXPOSE 9876
ENTRYPOINT ["java","-jar","/app.jar"]
