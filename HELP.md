# Read Me First

- my basic Dockerfile
- files from local Build directory for gradle **./build/libs/*.jar** 
- for Maven **target/*.jar** 
    ```dockerfile
    FROM eclipse-temurin:17-jdk-alpine
    VOLUME /tmp
    COPY ./build/libs/*.jar app.jar 
    EXPOSE 8080
    ENTRYPOINT ["java","-jar","/app.jar"]
    ```
- terminal scrypt
    ```shell
    docker build -t xander11m/myhelloapp .
    #run = create (container) + start container
    docker run -p 8080:8080 xander11m/myhelloapp 
    #or manually:
    docker create -p 8080:8080 xander11m/myhelloapp  
    # start/stop/pause/unpause/restart
    docker start CONTAINER_ID
    ```

## docker-compose.yml and DB dependency
### !!! please note
- **mongodb-container** - a container name of mongodb in the database URL 
- [example](https://salithachathuranga94.medium.com/deploy-rest-api-using-spring-boot-mongodb-and-docker-e7ab620b24d6)
    ``` yaml  
    spring:
      data:
        mongodb:
          uri: "mongodb://mongodb-container/docker-db"
    ```
docker create -p 27017:27017 -t mongodb-container mongo

docker run --name mongodb-container -p 27017:27017 mongo