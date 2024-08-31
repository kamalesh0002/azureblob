FROM openjdk:17
EXPOSE 8080
ADD target/azureblob-0.0.1-SNAPSHOT.jar azureblob-0.0.1-SNAPSHOT.jar
ENTRYPOINT [ "java","-jar","azureblob-0.0.1-SNAPSHOT.jar" ]
