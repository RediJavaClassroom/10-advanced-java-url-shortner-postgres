# URL Shortner with Database

----

## Where are we at?

* We know hot to build URL Shortner service that stores links in memory (class 3)
* We know how to spin up a docker container with Postgres (class 8)
* We know how to read and write data to Postgres using Spring JPA (class 9)

----

## Agenda for today
* We will add database support to our URL shortner service

----

## Spin up database
```
docker run --name shortlinks-db --publish 5432:5432 --env POSTGRES_PASSWORD=mysecretpassword --detach postgres
```

----

### Add Maven dependencies

Add in `pom.xml`

```xml
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-data-jpa</artifactId>
		</dependency>
		<dependency>
			<groupId>org.postgresql</groupId>
			<artifactId>postgresql</artifactId>
		</dependency>
```

-----

### Add configuration

To `application.properties`
```
spring.datasource.url=jdbc:postgresql://localhost:5432/postgres
spring.datasource.username=postgres
spring.datasource.password=mysecretpassword
spring.jpa.database-platform=org.hibernate.dialect.PostgreSQLDialect
spring.jpa.show-sql=true
spring.jpa.hibernate.ddl-auto=create
``` 

----

----

## Home assignment
