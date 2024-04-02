# Gambit Task

This is a simple JAVA application to solve the Gambit challenge task.
This will help you to translate the register values to the human-readable values

## Table of Contents

- [Technologies](#technologies)
- [Setup](#setup)
- [Usage](#usage)


## Technologies

- Java: The primary programming language used.
- Spring Boot: The framework used for building the application.
- Project Lombok: The library helps to reduce coding.

## Setup

This project is created using JAVA 17, so you need to have the version installed on your device. 
By cloning the repository you will need to compile it, and then you can run it in your local machine. This project works on port 8080 so make sure the port is open. there is a hard coded username and password for simple authentication you can use:
```agsl
user
password
```
to get access to the endpoints. 
```shell
# Example setup commands
git clone https://github.com/mehrdadmoradabadi/gambitChallenge-back.git
cd project-name
mvn clean install
java -jar target/modbus-0.0.1-SNAPSHOT.jar
```
## Usage
After successful installation and running the app you can use these endpoints to have access to the app.<p>
this will give you access to see all the implemented registers:
```agsl
http://localhost:8080/api/v1/register/all
```
to get the human-readable format you need to `post` a request to the following endpoint and also the payload should be in `text` format.
```agsl
http://localhost:8080/api/v1/register
```
the result is in `JSON` format.

