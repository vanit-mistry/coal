Step 1 - Application based on Java 17.

This application will create and preloads boundries, mining and claim tables.

NOTE
boundary data mining 2,2,250 has a  duplicate record entry in the original requirements. Only single record exists for this application.
Uses in memory DB http://localhost:8081/h2-console

Build
-------
mvn package (command to build application)

In target folder run java -jar Coal-1-0.0.1.jar

Invoke
---------
Use browser or postman (or equivalent)
http://localhost:8081/coal/hello - test server

http://localhost:8081/coal/getReportDetails - this will return a json object
1) boundary points (B1)
2) mining details lat/long and depth