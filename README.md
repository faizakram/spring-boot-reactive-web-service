# Spring Boot Reactive Skeleton #

To start with, the easiest option is to navigate to http://start.spring.io/ and create a Spring Boot application skeleton project. Make sure to select a Spring Boot version 2.0 or newer, the Reactive Web and the Reactive MongoDB dependencies.

Spring Boot 2.0 can integrate the WebFlux capabilities so let’s use its power to set up our backend. The first change we apply is already in our dependency management: we don’t include the MVC starter but the WebFlux one (spring-boot-starter-webflux). This starter contains the Reactor Netty server library dependencies, so Spring Boot will know that’s the one to start at runtime, and we’ll have available the Reactor API during development.

```
<dependencies>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-webflux</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-mongodb-reactive</artifactId>
    </dependency>
    <!-- ... -->
</dependencies>

```

On the other hand, the Reactive MongoDB dependencies are included with the starter spring-boot-starter-data-mongodb-reactive. This one pulls the Spring Data MongoDB dependency, containing Spring Data Commons 2.0 with reactive support, and the asynchronous and reactive-streams versions of the MongoDB driver.
