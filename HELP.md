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
    
    #show some info about image
    docker history 239 # (start of image_id)
    ```

---
## gradle::bootBuildImage
- setup **gradle::bootBuildImage**
    ```groovy
    bootBuildImage {
      imageName = "xander11m/${project.name}:${version}"
      publish = true
      docker {
          publishRegistry {
              url      = project.property('testDockerSpringContainerRepoUrl')
              username = project.property('testDockerSpringContainerRepoUser')
              password = project.property('testDockerSpringContainerRepoPassword')
          }
      }
  }
    ```

- terminal scrypt for **gradle::bootBuildImage**
    ```shell
  gradle clean bootBuildImage
  docker images
  dive xander11m/test-docker-spring:0.0.1-SNAPSHOT
  docker image rm --force IMAGE xander11m/test-docker-spring:0.0.1-SNAPSHOT
    ```
  
---
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
- terminal scrypt for **docker-compose**
    ```shell
  docker-compose build
  docker-compose up
  docker-compose down
    ```