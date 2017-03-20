FROM java:openjdk-8-jre

ADD target/jettyweb-jar-with-dependencies.jar /usr/bin/

ENTRYPOINT ["java","-jar","/usr/bin/jettyweb-jar-with-dependencies.jar"]

