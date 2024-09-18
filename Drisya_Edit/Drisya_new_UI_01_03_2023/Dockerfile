FROM openjdk:8-jre
ADD target/Drisya.jar Drisya.jar
EXPOSE 9098
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/Drisya.jar"]