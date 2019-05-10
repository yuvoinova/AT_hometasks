package task2.bankingLogic;

public class CreditAccount extends BankAccount {
	private double balance, limit;
	private int positiveFeeAmount, negativeFeeAmount;

	public CreditAccount(Customer owner, double limit) {
		this(owner, limit, 1, 5);
	}

	public CreditAccount(Customer owner, double limit, int positiveFeeAmount, int negativeFeeAmount) {
		setLimit(limit);
		balance = 0;
		this.setOwner(owner);
		owner.addCreditAccount(this);
		subscribe(owner);
		setPositiveFeeAmount(positiveFeeAmount);
		setNegativeFeeAmount(negativeFeeAmount);
		notifyAll("open credit account with limit: " + limit);
	}

	public double getBalance() {
		return balance;
	}

	public double getLimit() {
		return limit;
	}

	public void setLimit(double limit) {
		if ((limit >= 0) && (balance >= (double) (-1) * limit)) {
			this.limit = limit;
			notifyAll("set limit " + limit + " for credit account");
		} else {
			throw new IllegalArgumentException("Unable to set limit: " + limit + " is not acceptable");
		}
	}

	public int getPosotiveFeeAmount() {
		return positiveFeeAmount;
	}

	public void setPositiveFeeAmount(int positiveFeeAmount) {
		if ((positiveFeeAmount >= 0) && (positiveFeeAmount <= 100)) {
			this.positiveFeeAmount = positiveFeeAmount;
		} else {
			throw new IllegalArgumentException(
					"Unable to set positive fee amount: " + positiveFeeAmount + " is not a percentage");
		}
	}

	public int getNegativeFeeAmount() {
		return negativeFeeAmount;
	}

	public void setNegativeFeeAmount(int negativeFeeAmount) {
		if ((negativeFeeAmount >= 0) && (negativeFeeAmount <= 100)) {
			this.negativeFeeAmount = negativeFeeAmount;
		} else {
			throw new IllegalArgumentException(
					"Unable to set negative fee amount: " + negativeFeeAmount + " is not a percentage");
		}
	}

	public void addMoney(double addAmount) {
		if (addAmount >= 0) {
			balance = balance + addAmount;
			notifyAll("add " + addAmount + " to credit account");
		} else {
			throw new IllegalArgumentException("Unable to add money: " + addAmount + " is a negative number");
		}
	}

	public boolean isWithdrawAvailable(double withdrawAmount) {
		if ((withdrawAmount >= 0) && (withdrawAmount + calculatePaymentFee(withdrawAmount) <= (balance + limit))) {
			return true;
		} else {
			return false;
		}
	};

	public void withdrawMoney(double withdrawAmount) {
		if (isWithdrawAvailable(withdrawAmount)) {
			notifyAll("withdraw " + withdrawAmount + " from credit account. Payment fee is "
					+ calculatePaymentFee(withdrawAmount));
			balance = balance - withdrawAmount - calculatePaymentFee(withdrawAmount);
		} else {
			throw new IllegalArgumentException("Unable to withdraw money: " + withdrawAmount + " is not acceptable");
		}
	}

	public double calculatePaymentFee(double withdrawAmount) {
		if (withdrawAmount >= 0) {
			double positiveAmount = Math.max(Math.min(balance, withdrawAmount), 0);
			double negativeAmount = Math.max(withdrawAmount - balance, 0);
			return (double) (positiveFeeAmount * positiveAmount + negativeFeeAmount * negativeAmount) / 100;
		} else {
			throw new IllegalArgumentException(
					"Unable to calculate payment fee: " + withdrawAmount + " is a negative number");
		}
	}

	public void showAccounPlan() {
		System.out.println("This is a credit account:");
		System.out.println("     owner = " + owner.getName());
		System.out.println("     balance = " + utils.Utils.doubleView(balance));
		System.out.println("     limit = " + utils.Utils.doubleView(limit));
		System.out.println("     positive fee amount = " + positiveFeeAmount + " percent");
		System.out.println("     negative fee amount = " + negativeFeeAmount + " percent");
	}

}
