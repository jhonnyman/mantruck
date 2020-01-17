# MAN Code Challenge by João Mendes

## Project bundling

* The project is structured as a multi module setup

* $ mvn clean install
    - builds the whole project at the root

* Note: I was unable to fine tune the build configuration to make the angular application run with the spring backend in the war file.

* $ cd server/ && mvn spring-boot:run
    - Starts the backend

* $ cd frontend/ && npm start
    - Starts the frontend

## API Design

The API implementation was based on the Open API 3 standard and can be found in the swagger file [swagger.yml](./swagger.yml).

* For this exercise I considered just the following endpoints and methods for simplicity
 /trucks (GET, """"""PUT and POST)
    GET - fetches all trucks
    POST - creates a truck passing the object on the request body
 /trucks/{id} (GET, POST, DELETE)
    GET - fetches one truck
    PUT - updates a given truck passing the object on the request body
    POST - updates a truck passing form params
    DELETE - deletes one truck

* Response status codes were considered for each applicable method
    - 200 - Response was ok
    - 201 - A new truck was created
    - 400 - Input params not accepted
    - 404 - No data found in the database

* For the sake of simplicity I modeled the truck object with the following attributes
    - colors
    - engineHP
    - engineVolume
    - name
    - segments
    - fuel

    The goal of this model is to save the main information about the truck in one database table "TRUCK": engine HP, engine volume (cm3), name, segments, fuel, available colors.
    In this way the segments and colors are arrays and saved as a single string in the database as a CSV format.
    The purpose of this modulation was to make things simple. In a real entreprise application I would model a database to contain the reference data of each attribute and connect to the model via a third table containing the foreign keys of table truck and reference data tables.
    Then a more endpoints to configure the reference data would be necessary.

## Spring Backend design

* The Spring application was build on top of the generated backend from [editor.swagger.io](https://editor.swagger.io/)

* Since the backend only requires doing simple CRUD operations the following layers were considered
    - Controllers
    - Business Logic
    - Data access layer
    - Repositories

    If higher complexity of operations were required, I would add and additional layer for Services implementing the Repositories operations.

* The data is saved in a H2 in-memory database created in realtime after starting the backend

    The database schema and dummy data are run at boot time via configuration files [schema.sql](./server/src/main/resources/schema.sql) and [data.sql](./server/src/main/resources/data.sql).

* For the application testing two classes were considered for unit tests and integration tests.

    - TruckModelTests - unit tests for the Truck model
    - TruckapiApplicationITTests - tests all REST endpoints for success and some failures


## Angular Frontend Design

* The angular application was created in 3 steps using the angular-cli

    1. Creating an empty library, which also creates a multi angular project setup
    2. Download the generated API Client from [editor.swagger.io](https://editor.swagger.io/)
    3. Creating the main frontend angular aplication

    This way the angular project ends up with this structure

    - /frontend/projects/portal => contains the main frontend app
    - /frontend/projects/truckapiclient => contains the generated API Cliente library

    If, in the future, new custom libraries were needed then 2 options could be on the table:

    1. Generate the library structure inside the project folder using the angular CLI.
    2. Deploying the library packages to a remote private repository and import in the main project.

* The application has 3 main screens on the following paths
    - /list presents the list of trucks
    - /edit/{id} edits one truck info
    - /create creates a new truck


## Versioning

* I created this public repository to save the intermidiate states while developping on the branch feature.

* The changes were finally merged with the Master