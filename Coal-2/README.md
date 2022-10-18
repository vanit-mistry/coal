Step 2 - Application based on Java 17.

This application will create and preloads boundries, mining and claim tables.

NOTE
boundary data mining 2,2,250 has a  duplicate record entry in the original requirements. Only single record exists for this application.
Uses in memory DB http://localhost:8082/h2-console

Build
-------
mvn package (command to build application)

In target folder run java -jar Coal-2-0.0.1.jar

Invoke
---------
Use browser or postman (or equivalent)
http://localhost:8082/coal/hello - test server

http://localhost:8082/coal/getReportDetails - this will return a list of report details in a json object
1) boundary points (B1 and B2)
2) List of mining details, if any exist 
3) List of claim details, if any exist