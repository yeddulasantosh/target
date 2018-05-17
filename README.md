Environment : Spring Boot, MongoDB, Mockito

curl -i -H "Accepts:application/json" http://localhost:8080/products/13860428

curl -i -X PUT -H "Content-Type:application/json" http://localhost:8080/products/13860428 -d "{\"id\":\"13860428\",\"name\":\"The Big Lebowski (Blu-ray)\",\"current_price\":{\"value\":\"20\",\"currency_code\":\"US\"}}"

