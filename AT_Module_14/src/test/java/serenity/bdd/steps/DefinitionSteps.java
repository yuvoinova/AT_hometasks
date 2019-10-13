package serenity.bdd.steps;

import net.thucydides.core.annotations.Steps;
import serenity.bdd.steps.serenity.EndUserSteps;
import serenity.bdd.apis.config.Config;
import serenity.bdd.apis.model.*;

import org.assertj.core.api.Assertions;
import org.assertj.core.api.SoftAssertions;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import io.restassured.response.Response;

public class DefinitionSteps {

	@Steps
	EndUserSteps endUser;

	@Given("the user is on the Wikionary home page")
	public void givenTheUserIsOnTheWikionaryHomePage() {
		endUser.open_brauser();
		endUser.is_the_home_page();
	}

	@When("the user looks up the definition of the word $word")
	public void whenTheUserLooksUpTheDefinitionOf(final String word) {
		endUser.looks_for(word);
	}

	@Then("they should see the definition $definition")
	public void thenTheyShouldSeeADefinitionContainingTheWords(final String definition) {
		endUser.should_see_definition(definition);
	}

	@Given("I have an URI of StoreInventory Endpoint")
	public void givenIHaveAnUriOfStoreInventoryEndpoint() {
	}

	@When("I make a get request to StoreInventory")
	public void iMakeAGetRequestToStoreInventory() {
		endUser.makeRequestgetStoreInventory();
	}

	@Then("I should get non-empty response with status code 200")
	public void iShouldGetNonEmptyResponseWithStatusCode200() {
		Response storeInventoryResponse = endUser.getResponse();
		SoftAssertions assertions = new SoftAssertions();
		assertions.assertThat(storeInventoryResponse.getStatusCode()).isEqualTo(200);
		assertions.assertThat(storeInventoryResponse.getBody().toString()).isNotEmpty();
		assertions.assertAll();
	}

	@Given("I have an order")
	public void iHaveAnOrder() {

	}

	@When("I make a post request to StoreOrder")
	public void iMakeAPostRequestToStoreOrder() {
		endUser.makeRequestCreateOrder(Order.createTestOrder());
	}

	@Then("I should make sure that the order appears in the system")
	public void iShouldMakeSureThatTheOrderAppearsInTheSystem() {

		Response orderResponse = endUser.getResponse();	
		long createdOrderId = orderResponse.body().as(Order.class).getId();
		endUser.makeRequestgetOrderById(createdOrderId);
		Order createdOrderFromService = endUser.getResponse().as(Order.class);
		SoftAssertions assertions = new SoftAssertions();
		assertions.assertThat(createdOrderFromService.getPetId()).as("PetId").isEqualTo(Order.createTestOrder().getPetId()).toString();
		assertions.assertThat(createdOrderFromService.getQuantity()).as("Quantity").isEqualTo(Order.createTestOrder().getQuantity());
		assertions.assertAll();
	}

	@Given("I create an order")
	public void iCreateAnOrder() {
		endUser.makeRequestCreateOrder(Order.createTestOrder());
	}

	@When("I make a delete request for $order by id")
	public void iMakeADeleteRequestForOrderById() {
		endUser.makeRequestDeleteById(Order.createTestOrder().getId());
	}

	@Then("I should make sure that the order not appears in the system")
	public void iShouldMakeSureThatTheOrderNotAppearsInTheSystem() {
		Response orderById = endUser.getOrderById(String.valueOf(order.getId()));
		Assertions.assertThat(orderById.getStatusCode()).isEqualTo(404);
	}

}
