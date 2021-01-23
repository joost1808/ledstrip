FROM registry.gitlab.com/avisi/base/java:8-headless

HEALTHCHECK \
    CMD curl -o /dev/null --silent --write-out '%{http_code}\n' http://localhost:8081/actuator/health | grep 200

EXPOSE 8080
EXPOSE 8081

COPY build/libs/*.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]
