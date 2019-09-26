To clone this demo (you've already done this if you're reading this!)

git clone https://github.com/danhull76/planet-demo.git

This project uses Java 11 and Maven.  It is a simple Spring Boot setup with a repository, service, and controller layer.  ThymeLeaf is used for basic MVC.  On startup, the application loads the specified JSON file into H2.  This is not necessarily the most efficient way to work with a JSON file, but does allow me to use the exercise to show off a little bit more of a standard web service stack by adding a relational database and a few different ways of interacting with it.

If you prefer to run from IntelliJ:
* The tests can be run by right clicking on the PlanetsApplicationTests class and selecting "Run 'PlanetsApplicationTests'"

* The application can be started by right-clicking on the PlanetsApplication class and selecting "Run'PlanetsApplication'"

If you prefer to run from the command line:
* "mvn test" will execute the tests

* "mvn spring-boot:run" will start the application

Once started, the application will be available at localhost:8080/ via web browser.  There is simple HTML navigation to the various answers requested.


To run in a docker container:

* Build the image: docker build --tag=planet-demo:latest --rm=true .
* Start the image: 