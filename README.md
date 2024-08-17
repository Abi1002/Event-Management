# Event-Management

## Technologies Used :

#### Springboot for Backend server
#### React Js for Client-server
#### Mysql for Database

## Requirements :

#### Node js
#### Java 17
#### MySQL
#### IDE for front-end : VsCode
#### IDE for back-end: IntelliJ (or) Eclipse (or) Spring tool suite

## Instructions to run the project

Download the Event-Management Zip file.

### Set-up database :
1. Open the Mysql workbench.
2. Create a new database using the command
            "create database database_name" 


### Set-up front-end :
1. Open the event-management-client-main folder in VsCode.
2. Install the "Vite" package in Node Js.
3. Install the "npm", and "react-bootstrap" packages.
4. Now start the server with the command
               "npm run dev"



### Set-up back-end :
1. Open the event-management-server folder with your preferred back-end IDE.
2. Set up the Java version SDK for the project.
3. Go to the application.properties file.
4. Edit your Database name and password.
5. Go to the EventManagementApplication file.
6. To run the server, click the play button at the top.
7. Go to the Mysql workbench and check whether the tables have been successfully created.
8. Select the role table and apply these values
                      id: 1, name: ROLE_ADMIN
                      id: 2, name: ROLE_USER   



## Application Usage Instructions:

1. With a perfect start to the application, you will be on the home page of the application.
2. Go to Account in the top-right corner of the navigation bar.
3. Go to the login page and click on the register to create a new user.
4. The application will always assign the Role "user" to all the users.
5. To create an admin, go to the workbench select the user_role table, and execute the query
                        "use database_name;
                         Alter table user_role add primary key (user_id);"
6. Now manually modify any user you want as an admin by changing their role_id as 1.


# APPLICATION IS NOW READY TO USE!!!














