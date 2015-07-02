# Weather-Application
Spring-MVC-maven based weather application

#Steps to run this project on your local machine.

1)To download/clone this project onto your local machine run the below command in git bash(command line utility to download git projects)

 `git clone https://github.com/ucancprem/Weather-Application.git`

2) use `cd` command and navigate into folder "Weather-Application" (directory containing pom.xml)


3) use `mvn compile` to compile the project (you can run this command from git bash or command prompt)

4) In this directory containing pom.xml, use the below command to run the project using tomcat 7.

`mvn clean install tomcat7:run`

5) Use the below URL to access the home page of the project.

`http://localhost:8080/weatherdisplay/display` or click  
[access home page!](http://localhost:8080/weatherdisplay/display)

#Run Unit Tests

#a) Run all the methods in both test classes using below commands

`mvn -Dtest=WeatherMockServiceTest test` (Total of 11 test methods)

`mvn -Dtest=RestMockTest test` (Total of 5 test methods)

#b) To run each method induvidually use commands below

**Mock Form validation when zip is more than 5 characters long.**

`mvn -Dtest=RestMockTest#testForErrorMoreThanFiveDigits test`

    
**Mock Form with invalid ZIP and check for Error Message.**

mvn -Dtest=RestMockTest#testForErrorWithErrorMessage test`


**Mock Form with valid 5-digit ZIP and check for errors.**

`mvn -Dtest=RestMockTest#testForValidFiveDigitZip test`



**Mock Form validation when zip is less than 5 characters long.**

`mvn -Dtest=RestMockTest#testForErrorLessThanFiveDigits test`



**Mock Form validation when entered empty String.**

`mvn -Dtest=RestMockTest#testEmptyZip test`



**Mock to check 5-digit zip code which is not present.**

`mvn -Dtest=RestMockTest#createOrUpdateSuccessful test`


**Mock Form to non-digit zip code entry.**

`mvn -Dtest=RestMockTest#testForErrorCharacterAsZipInput test`



**Check Basic page rendering.**

`mvn -Dtest=RestMockTest#checkForPageDisplay test`


**Mock Form to test view name when an valid zip is entered.**

`mvn -Dtest=RestMockTest#testViewNameWithValidZip test`



**Mock Form to test view name when an invalid zip is entered.**

`mvn -Dtest=RestMockTest#testViewNameWithInValidZip test`


**Mock Form with valid 9-digit ZIP and check for errors.**

`mvn -Dtest=RestMockTest#testForValidNineDigitZip test`


** Mock Form with valid 5-digit ZIP and check for errors.**

`mvn -Dtest=RestMockTest#testForValidFiveDigitZip test`




**basic mock request validation.**

`mvn -Dtest=RestMockTest#performRequestValidation test`

	
**Test mock rest remplate response(valid).** 

`mvn -Dtest=RestMockTest#testRestSuccessfulResponse test`



**Test weatherService to correctly check for error response.**

`mvn -Dtest=RestMockTest#testRestErrorResponse test`


		
**Test weatherService to correctly check for error response.**

`mvn -Dtest=RestMockTest#testZipCodeNotFound test`



**Test to check json to display object mapping.**

`mvn -Dtest=RestMockTest#testSuccessResultMapping test`
