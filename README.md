# Test Concurrency

A sample Spring Boot project showing the use of concurrency with Java and SpringBoot 

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

### Prerequisites

* Gradle - optional
* Java (JDK/JRE)
* Preferred IDE
* Docker

### Installing

A step by step series of examples that tell you how to get a development env running

After cloning the project from the repository run following command to build the project on Eclipse based IDE-s:

```
gradle build eclipse
```
If using IntelliJ Idea run:

```
gradle build idea
```

If the project build ends correctly you can start it through the console by running the following command:

```
gradle bootrun
```

If gradle is not installed locally on your PC, you can run it with the gradle wrapper which is included in the root of the project.

From the root of the project using the console run:

For *nix systems:

```
./gradlew build eclipse
./gradlew bootrun
```
For Windows:

```
gradlew.bat build eclipse
gradlew.bat bootrun
```
## Running the unit tests

Tests not implemented.

## End to end test

To test the concurrency, simply copy the following block into your console and execute it.
Do change the /some/output/folder/ path to a path that exists on your machine.

### Warning
Chaining the curl command with the "&" runs the commands concurrently and work ONLY only on *nix systems. If your run it in cmd or PS on Windows,
the commands will be run sequentially. If you have Git installed with GitBash, you can run it concurrently that way.

```
curl http://localhost:8080/test/concurrency -o /some/output/folder/output1.txt &
curl http://localhost:8080/test/concurrency -o /some/output/folder/output2.txt &
curl http://localhost:8080/test/concurrency -o /some/output/folder/output3.txt &
curl http://localhost:8080/test/concurrency -o /some/output/folder/output4.txt &
curl http://localhost:8080/test/concurrency -o /some/output/folder/output5.txt &
curl http://localhost:8080/test/concurrency -o /some/output/folder/output6.txt &
curl http://localhost:8080/test/concurrency -o /some/output/folder/output7.txt &
curl http://localhost:8080/test/concurrency -o /some/output/folder/output8.txt &
curl http://localhost:8080/test/concurrency -o /some/output/folder/output9.txt &
curl http://localhost:8080/test/concurrency -o /some/output/folder/output10.txt &
curl http://localhost:8080/test/concurrency -o /some/output/folder/output11.txt &
curl http://localhost:8080/test/concurrency -o /some/output/folder/output12.txt &
curl http://localhost:8080/test/concurrency -o /some/output/folder/output13.txt &
curl http://localhost:8080/test/concurrency -o /some/output/folder/output14.txt &
curl http://localhost:8080/test/concurrency -o /some/output/folder/output15.txt
```


## Deployment

The project is intended to be deployed as a Docker container.

Building the container is done through the console using the Docker command from the root of the project:

```
docker build --tag=test-concurrency .
```

Run the container with the following command:

```
docker run -d -p 8080:8080 --name test-concurrency test-concurrency
```

## Built With

* [Gradle](https://gradle.org/) - Dependency Management and build tool

## Running docker

## Authors

* **Ivan Novak** - *Initial work*
