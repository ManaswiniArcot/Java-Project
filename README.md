# Java-Project
Java-Project
This is a Java project for the following requirements: 1) Build a small app that consists of 4 endpoints.

Build an endpoint that authenticates a user based on a login/password passed in a JSON payload and verifies against a simple data structure (Mongo, MySQL, etc.).
Build an endpoint that returns all users in the database filtered by a URL parameter (can be city, profession, etc) and groups them by another parameter (also your choice).
Build an endpoint that checks and returns the status of all components that it depends on (e.g. Is Mongo still up OK, etc.).
Build an endpoint that when called returns the list of files in a given directory. 2) Deliverables
Commit to GitHub (if you don't have a GitHub account...no problem as they are free to create)
Source code + deployment instructions 3) Things to consider for your "readme" doc.
Use the technologies of your choice but please add a small paragraph on why you choose that technology.
The endpoints have to be able to handle versioning, please explain the strategy on how to accomplish this.
If you have time please add pagination, if not please describe how the solution would support pagination
I have choosen Java Technology to work on this Challenge and Spring MVC frame work implement this.The idea behind using this framework is that, its light weight, separates the Business logic,Input Logic and the UI logic . once we define the Dispatcher-servlet/Controller class which takes care of all the requests from the client. And a separate View Resolver that generates views based on the Model Object sent from the Controller Class. Dispatcher servlet helps the in finding the appropriate class/method to execute the process.Any change in the business requirement, needs change in buisness logic classes only.

Hibernate enables us to write code efficiently,using the annotations.Can get rid of XML code mappings that are otherwise required. Connected to the MySQL using JDBC driver and Used ApacheTomcat 8.0 Sever.

Main Files
web.xml
SpringDispatcher-servlet.xml
AppController.java

You Need to Run this Application in Eclipse using Apache Tomcat 8.0 Server.
And need to install MySQL also.
Apache Tomact: https://tomcat.apache.org/download-80.cgi
MySQL: http://dev.mysql.com/downloads/mysql/

Once you install the MySQL server,run the below queries to create a database and table Create database my_test; CREATE USER 'marcot'@'localhost' IDENTIFIED BY 'manu'; GRANT SELECT, INSERT, UPDATE ON 'my_test'.* TO 'marcot'@'localhost'; CREATE table my_user values(first_name varchar(100),last_name varchar(100), user_id int not null,profession varchar(100),city varchar(100),state varchar(50),country varchar(50),user_email varchar(320),password varchar(100));

insert into my_user values('Kavya','Rao',110,'engineer','devon','AP','India','manu@gmail.com','manu');
insert into my_user values('Raja','Katrina',111,'doctor','vijayawada','AP','India','teja@gmail.com','teja'); 
insert into my_user values('Rakesh','Smith',116,'engineer','Farefax','VA','USA',null,null); 
insert into my_user values('John','Bob',113,'engineer','Fare Fax','VA','USA',null,null); 
insert into my_user values('berry','Vang',118,'doctor','NashVille','NC','USA',null,null); insert into my_user values('Cherry','Araku',114,'teacher','Knr','AP','India',null,null); insert into my_user values('Aravi','Gad',115,'lawyer','Wgl','AP','India',null,null);

Make Sure to import the library files in the web-inf/lib folder and set the classpath properly.
Endpoints: http://localhost:8081/MyJavaChallenge/ 
Generates the page to enter the username and pwd ,passes them as a json payload and verifies it from the database and generates a json payload string. I have added two records for the purpose of testing.

Welcome Page http://localhost:8081/MyJavaChallenge/welcome
Has the links for the other endpoints. Can access any of the endpoints from this page.

http://localhost:8081/MyJavaChallenge/searchUser 
allows to search the user.if the search criteria matches the record returns the list of users.else shows the message.

http://localhost:8081/MyJavaChallenge/files
Gives the list of files and directories in the given path.

http://localhost:8081/MyJavaChallenge/status
Sends the status of MySQL and the Tomcat server.

Insufficient time to implement Pagination and Version Handling.Below are the ideas to implement them.

To handle the version control on the project. 
In my past experience I have used the IBM Rational clear case for the version Control.
Merge the changes from the local repository to the master/repo, checkin the code and check out the changes. 
As the per new technologies,the easy and more conformatable VCS than existing tools(source Internet.)
We can use the Egit that is the Git Repository to share the projects. Can create Local repositories, and working tree branches and later on commit the local changes to the master repository. Git takes care of the versions and we can track the changes(commits). The modifications made through the Git are faster than any other version control softwares. EGit would be the best VCS for this project Using Eclipse.

Pagination can be done by an inbuilt class provided by the Spring beans PageListHolder class. By implementing this class, we can add the feature of pagination for this project.
