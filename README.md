# Spring Modulith Demo

`Spring Modulith` is an add-on library for Spring Boot that helps developers structure and maintain a cleaner project
architecture.

Its core concept is to separate business features into encapsulated modules. Each module defines a well-defined public
API for external access and keeps its internal implementation hidden from other modules.

`Spring Modulith` provides tooling to enforce and verify these architectural boundaries through automated tests (
see [ModularityTest](src/test/java/org/exmaple/ModularityTest.java)). Additionally, it creates architectural
documentation which can be found in `./docs` (automatically updates when using `mvn verify` or by running the `GitHub CI/CD`).

## Init runtime dependencies

This project requires a PostgreSQL database to be running before starting the application. The included Docker Compose
file will start a Postgres 16 container configured with the default credentials and database.

``` bash 
cd docker
docker compose up -d
```

##    