# Weather-Application
Spring-MVC-maven based weather application

#Steps to run this project on your local machine.

1)To download/clone this project onto your local machine run the below command in git bash(command line utility to download git projects)

 `git clone https://github.com/ucancprem/Weather-Application.git`

2) use `cd` command and navigate into folder "Weather-Application" (directory containing pom.xml)

3) In this directory containing pom.xml, use the below command to run the project using tomcat 7.(you can run this command from git bash or command prompt)

`mvn clean install tomcat7:run`

4) Use the below URL to access the home page of the project.

`http://localhost:8080/weatherdisplay/display` or click here 
[access home page!](http://localhost:8080/weatherdisplay/display)

5) Some of the Inputs you may want to use
1) no zip code (Invalid)
2) 00 (Invalid)
3) 00000 (Invalid)
4) 07104 (valid)
5) 02201-1020 (valid)
6) aaa(Invalid)

