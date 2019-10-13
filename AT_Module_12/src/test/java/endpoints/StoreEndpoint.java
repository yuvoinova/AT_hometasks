package endpoints;

import config.Config;
import model.Order;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.apache.http.HttpHeaders;

public class StoreEndpoint {
	
    private RequestSpecification given() {
        return SerenityRest.given()
                .baseUri(Config.PETSTORE_BASE_URL)
                .header(HttpHeaders.CONTENT_TYPE, "application/json");
    }
	
    @Step("get StoreInventory")
    public Response getStoreInventory(String storeInventoryUri){
        return SerenityRest.given()
        			.header(HttpHeaders.CONTENT_TYPE, "application/json")
        		.when()
                	.get(storeInventoryUri)
               .then().extract().response();
    }
    
    @Step("create Order")
    public Response createOrder(Order order) {
    	return given()
    				.body(order)
    			.when()
    				.post(Config.CREATE_ORDER)
    			.then().extract().response();
    }
    
    @Step("get Order by Id")
    public Response getOrderById(String id) {
    	return given()
    				.pathParam("orderId", id)
    			.when()
    				.get(Config.ORDER_BY_ID)
    			.then().extract().response();
    }
    
    @Step("delete Order by Id {}")
    public Response deleteById(long id){
        return given()
        			.pathParam("orderId", id)
                .when()
                	.delete(Config.ORDER_BY_ID)
                .then().extract().response();
    }
    

}
