package tests;

import endpoints.StoreEndpoint;

import io.restassured.response.Response;
import model.Order;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.SoftAssertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SerenityRunner.class)
public class TestStore {

	@Steps
	public StoreEndpoint storeEndpoint;

	@Before
	public void cleanup() {
		storeEndpoint.getOrderById(String.valueOf(Order.createTestOrder().getId()));

	}

	@Test
	@Title("verification of get StoreInventory")
	public void verifyStoreInventory() {
		Response storeInventoryResponse = storeEndpoint.getStoreInventory();
		SoftAssertions assertions = new SoftAssertions();
		assertions.assertThat(storeInventoryResponse.getStatusCode()).isEqualTo(200);
		assertions.assertThat(storeInventoryResponse.getBody().toString()).isNotEmpty();
		assertions.assertAll();
	}

	@Test
	@Title("verification of post StoreOrder")
	public void verifyStoreOrderCreation() {
		// Given
		Order order = Order.createTestOrder();
		// When
		Response orderResponse = storeEndpoint.createOrder(order);
		// THEN
		long createdOrderId = orderResponse.body().as(Order.class).getId();
		Order createdOrderFromService = storeEndpoint.getOrderById(String.valueOf(createdOrderId)).as(Order.class);
		SoftAssertions assertions = new SoftAssertions();
		assertions.assertThat(createdOrderFromService.getPetId()).as("PetId").isEqualTo(order.getPetId()).toString();
		assertions.assertThat(createdOrderFromService.getQuantity()).as("Quantity").isEqualTo(order.getQuantity());
		assertions.assertAll();
	}

	@Test
	@Title("verification of delete StoreOrder")
	public void deleteOrder() {
		// Given
		Order order = Order.createTestOrder();
		storeEndpoint.createOrder(order);
		// When
		storeEndpoint.deleteById(order.getId());
		// Then
		Response orderById = storeEndpoint.getOrderById(String.valueOf(order.getId()));
		Assertions.assertThat(orderById.getStatusCode()).isEqualTo(404);
	}

}
