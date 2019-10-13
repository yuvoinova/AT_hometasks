package serenity.bdd.steps.serenity;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import properties.EnvironmentPropertyLoader;
import serenity.bdd.AcceptanceTestSuite;
import serenity.bdd.apis.config.Config;
import serenity.bdd.apis.model.Order;
import serenity.bdd.pages.DictionaryPage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasItem;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.restassured.response.Response;

public class EndUserSteps {

    DictionaryPage dictionaryPage;
    
    @Step
    public void open_brauser() {
		Logger log = LoggerFactory.getLogger(AcceptanceTestSuite.class);
		String environment = EnvironmentPropertyLoader.getInstance().getProperty("environment");
		log.info("environment=" + environment);		
    }

    @Step
    public void enters(String keyword) {
        dictionaryPage.enter_keywords(keyword);
    }

    @Step
    public void starts_search() {
        dictionaryPage.lookup_terms();
    }

    @Step
    public void should_see_definition(String definition) {
        assertThat(dictionaryPage.getDefinitions(), hasItem(containsString(definition)));
    }

    @Step
    public void is_the_home_page() {
        dictionaryPage.open();
    }

    @Step
    public void looks_for(String term) {
        enters(term);
        starts_search();
    }
    
   
    @Step
    public Response getResponse() {
    	return SerenityRest.then().extract().response();
    }
	
    @Step
    public void makeRequestgetStoreInventory(){
        SerenityRest.given()
        				.contentType("application/json")
        				.baseUri(Config.PETSTORE_BASE_URL)
        			.when()
        				.get(Config.STORE_INVENTORY);
    }
      
    @Step 
    public void makeRequestCreateOrder(Order order) {
    	SerenityRest.given()
    					.contentType("application/json")
    					.baseUri(Config.PETSTORE_BASE_URL)
    					.body(order)
    				.when()
    					.get(Config.CREATE_ORDER);
    }
    

    
    @Step
    public void makeRequestgetOrderById(long id) {
    	SerenityRest.given()
    				.pathParam("orderId", id)
    			.when()
    				.get(Config.ORDER_BY_ID);
    }
    
    @Step
    public void makeRequestDeleteById(long id){
    	SerenityRest.given()
        			.pathParam("orderId", id)
                .when()
                	.delete(Config.ORDER_BY_ID);
    }
}