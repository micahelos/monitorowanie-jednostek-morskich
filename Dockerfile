FROM openjdk:11
ADD target/tracker.system-0.0.1-SNAPSHOT.jar .
COPY backup3.sql ./
EXPOSE 8080
CMD java -jar tracker.system-0.0.1-SNAPSHOT.jar