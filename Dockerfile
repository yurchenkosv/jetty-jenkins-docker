FROM java:openjdk-8-jre

COPY target/*.jar /usr/bin/

ENTRYPOINT ["java","-jar","/usr/bin/webserver-test-1.0-SNAPSHOT.jar"]

