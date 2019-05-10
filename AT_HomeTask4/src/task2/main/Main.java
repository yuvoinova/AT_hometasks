package task2.main;

import task2.bankingLogic.CreditAccount;
import task2.bankingLogic.Customer;
import task2.bankingLogic.DebitAccount;

public class Main {
	public static void main(String[] args) {
		Customer customer1 = new Customer("Gosha Adulterer");
		DebitAccount debitAccount = new DebitAccount(customer1);
		Customer customer2 = new Customer("Jealous Wife");
		debitAccount.subscribe(customer2);
		debitAccount.addMoney(1000);
		debitAccount.showAccountPlan();
		debitAccount.withdrawMoney(8);
		debitAccount.showAccountPlan();
		CreditAccount creditAccount = new CreditAccount(customer1, 1000);
		creditAccount.addMoney(7);
		creditAccount.showAccounPlan();
		creditAccount.withdrawMoney(100);
		creditAccount.setLimit(98);
		creditAccount.showAccounPlan();
		debitAccount.unsubscribe(customer2);
		debitAccount.withdrawMoney(500);
		debitAccount.showAccountPlan();
	}

}
