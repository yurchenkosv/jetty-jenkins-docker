FROM java:openjdk-8-jre

COPY webserver-1.0-SNAPSHOT.jar /usr/bin/

ENTRYPOINT ["java","-jar","/usr/bin/webserver-1.0-SNAPSHOT.jar"]

