package task2.bankingLogic;

import java.util.ArrayList;

import task2.interfaces.Observer;
import task2.interfaces.Publisher;

public abstract class BankAccount implements Publisher {
	protected Customer owner;
	private ArrayList<Observer> subscribers = new ArrayList<Observer>();

	public Customer getOwner() {
		return owner;
	}

	protected void setOwner(Customer owner) {
		if (owner != null) {
			this.owner = owner;
		} else {
			throw new IllegalArgumentException("Unable to set owner: " + owner + " is null");
		}
	}

	public abstract void addMoney(double addAmount);

	public abstract void withdrawMoney(double withdrawAmount);

	public abstract double calculatePaymentFee(double withdrawAmount);

	public void subscribe(Observer observer) {
		subscribers.add(observer);
	}

	public void unsubscribe(Observer observer) {
		subscribers.remove(observer);
	}

	public void notifyAll(String data) {
		for (Observer subscriber : subscribers) {
			subscriber.onEvent(data);
		}

	};

}
