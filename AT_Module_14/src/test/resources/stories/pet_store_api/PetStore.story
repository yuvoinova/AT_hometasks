Cover /store endpoint with tests

Narrative:
In order to reduce the cost of error
As a tester
I want to define the behaviour of /store endpoint
					 
Scenario:  Verification of get StoreInventory
Given I have an URI of StoreInventory Endpoint
When I make a get request to StoreInventory
Then I should get non-empty response with status code 200
					 
Scenario:  Verification of post StoreOrder
Given I have an order
When I make a post request to StoreOrder
Then I should make sure that the order appears in the system

Scenario:  Verification of delete StoreOrder
Given I create an order
When I make a delete request for order by id
Then I should make sure that the order not appears in the system