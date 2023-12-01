# Read Me First

- my basic Dockerfile
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

