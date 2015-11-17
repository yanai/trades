# Spring Exercise

The following exercise can be developed:
* Either with spring-boot (Bonus, as it will be much shorter) or regular spring web project. 
* Either with JDK 1.8 (Bonus) or lower versions
* Either with Spring-Data-JPA(Bonus)  or without
* Either with Maven or Gradle(Bonus) 
* You can use your favorite IDE, and DB (you will also use in-memory DB for testing).


### Exercise 1
In this Exercise you need to create a “Trading Application” using Spring. 

This application should have two entities: Trader and Transaction. Each Transaction is associated to the trader who executed it. 
The properties for the trader are (id:Integer, name:String, city:String). 
The properties for the Transaction are (id:Integer, trader:Trader, year:int, int:value).
Your mission is to create two beans that use the entities above (obviously you should create the entities as well): 
* TransactionMemoryRepository bean. This bean should hold two in-memory lists for the Traders and Transactions. You should initialize these list in Spring initialized method of the bean
* You should create five methods for this bean: 
  * Find all traders
  * Add a trader
  * Find all transactions for year
  * Find unique cities of traders who committed transactions ordered alphabetically
  * Find all traders who committed transaction for a given city

Bonus : Externalize some properties of your beans to external properties file.
Bonus Plus Plus : Write the code with Java8 Functional Programming style.


You should write a Spring test for this bean – Inject the bean to the test class and check all methods work.



### Exercise 2
* Create a RESTful Spring application that exposes the business method above, but this time you should use a RDBMS. You should do it by creating a Spring REST Controller bean (and optional a service bean).
The REST api should be as follow:
GET : http://localhost:8080/traders
POST : http://localhost:8080/traders
GET : http://localhost:8080/transactions?year=YEAR
GET : http://localhost:8080/transactions/cities
GET : http://localhost:8080/transactions/traders?city=CITY

* All DB properties (i.e. user, password, drive, DB-URL) should be externalized to properties file.
* Bonus : Use some connection pool (C3P0 or BoneCP)
* The Service above should delegate to a separate to Repository beans (TraderRepository and Transactionrepository) to apply the DB operations.
* Create TradeServiceTests class that test all the services above.
* Secure the application by providing basic authentication for the application. You should enable at least one user to check this.
* Bonus: Check the REST api with RestTemplate

