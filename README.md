Project Name : MyRetailService

Environment : Spring Boot, MongoDB, Mockito, Eclipse IDE, Maven

Project was build with maven

To run the jar use java -jar myretail-0.0.1-SNAPSHOT

Http Methods implemented
   -> GET
   -> PUT

Can be tested with

curl -i -H "Accepts:application/json" http://localhost:8080/products/13860428

curl -i -X PUT -H "Content-Type:application/json" http://localhost:8080/products/13860428 -d "{\"id\":\"13860428\",\"name\":\"The Big Lebowski (Blu-ray)\",\"current_price\":{\"value\":\"20\",\"currency_code\":\"US\"}}"


