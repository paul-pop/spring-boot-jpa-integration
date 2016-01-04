# spring-boot-jpa-integration

## Summary
Spring Boot JPA integration using Spring Data and H2 database run in-memory. Just uses a REST controller
to return existing data from the DB.

## Build and Startup
You will need to have Java 8 JDK and Maven 3 in order to build successfully.
Simply build the application by running: 
```
mvn clean install
```

The application can be started:
* From **IntelliJ** - by running the main method inside the **com.andigital.api.Application** class.
* From the **command line** - by running the following command from the current folder:
```
java -jar target/andigital-spring-data-jpa-api.jar
```

## Run
Once the application is started, you can perform a GET request on:
```
http://localhost:8080/say?what=Hello&to=Antonio
```