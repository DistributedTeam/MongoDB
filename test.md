# Testing

### General Information

To verify if the project is set up correctly, a set of data files and tests are included in the project.

### Prerequisite
- MongoDB
- [Java 8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html) and above

### Import Test Data

The `gradlew` script assumes by default that MongoDB runs on IP address `127.0.0.1:27017`. 

To change default IP address, change `mongodb.ip` in `import/project.test.properties`

Run command `gradlew import:test`.

### Run Tests

Ensure MongoDB is running.

To run all internal tests

1. Run command `gradlew test`.

All tests should pass if the project is set up correctly.

To run a specific test


1. Open project in Java IDE
2. Find and run test file in subfolders of directory `\client\src\test\java\client\cs4224c\transaction\`.

 