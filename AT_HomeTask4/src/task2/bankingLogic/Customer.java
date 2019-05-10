package task2.bankingLogic;

import java.util.ArrayList;

import task2.interfaces.Observer;

public class Customer implements Observer {
	private String name;
	private ArrayList<DebitAccount> debitAccounts = new ArrayList<DebitAccount>();
	private ArrayList<CreditAccount> creditAccounts = new ArrayList<CreditAccount>();

	public Customer(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void onEvent(String data) {
		System.out.println("Data in customer " + name + ": " + data);
	}

	void addDebitAccount(DebitAccount debitAccount) {
		debitAccounts.add(debitAccount);
	}

	void addCreditAccount(CreditAccount creditAccount) {
		creditAccounts.add(creditAccount);
	}

}
