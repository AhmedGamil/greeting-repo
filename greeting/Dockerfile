FROM openjdk:11

ADD ./target/greeting-0.0.1-SNAPSHOT.jar /app/
CMD ["java", "-Xmx200m", "-jar", "/app/greeting-0.0.1-SNAPSHOT.jar"]

EXPOSE 5000