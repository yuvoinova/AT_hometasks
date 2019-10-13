package model;

public class Order {
	private long id;
	private long petId;
	private int quantity;
	private String shipDate;
	private String status;
	private boolean complete;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getPetId() {
		return petId;
	}

	public void setPetId(long petId) {
		this.petId = petId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getShipDate() {
		return shipDate;
	}

	public void setShipDate(String shipDate) {
		this.shipDate = shipDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public boolean isComplete() {
		return complete;
	}

	public void setComplete(boolean complete) {
		this.complete = complete;
	}

	public static Order createTestOrder() {
		Order order = new Order();
		order.setId(123);
		order.setPetId(0);
		order.setQuantity(1);
		order.setShipDate("2019-10-12T20:45:21.346+0000");
		order.setStatus("placed");
		order.setComplete(false);
		return order;
	}
}
