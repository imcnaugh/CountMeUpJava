# Count Me Up in Java

This is a web application to keep track of an election.

This project was built using java 8, in intellij, using spring boot, and gradle. 

# Setup
use `./gradlew build` to build the project.
`java -jar build/libs/CountMeUp.jar` will run the project.

# Usage
After the project has started, you can access the endpoints manualy, or use the swagger ui. It can be found at `http://localhost:8080/swagger-ui.html#!` after the project has started.
Currently only one election can run at a time. 
Candidates must be added to the election using the candidate endpoint.
Users must be added by the user endpoint.
To vote, you must supply a valid user and candidate id.
A user may only vote up to 3 times.
Calling the ElectionController's GET method will return the current results of the election

For convience there is an extra method that will set up an election. This method takes an array of candidates names, and a number of votes you would like in the election. This methods will create as manay users as needed.

# Final notes
Previously I had built this project in Scala (https://github.com/imcnaugh/CountMeUp). This itteration is not using a DB on the back end, but should make do assuming you give the JVM enough memmory. This itteration on the other hand comes with a working API and a swagger instance to interface with the project.
