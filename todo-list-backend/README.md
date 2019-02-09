A sample "ToDo List" project to demonstrate how a web app can be built using a Spring Boot / AngularJs stack. 
The frontend is based on AngularJs 6 and the backend is composed of JSON REST web services based on Spring Boot / JPA.

The following dependencies are necessary: 

 - Java 8
 - maven 3
 - mysql

Application DB is based on MySql and should be prepared before start project. 
Previously there  should be created "todo-test-demo" schema and user with "root/root" credentials. 

To build the backend and start the server, run the following command on the root folder of the repository:

    mvn clean spring-boot:run

The application is accessible at the following URL:

    http://localhost:8080/
    
     

