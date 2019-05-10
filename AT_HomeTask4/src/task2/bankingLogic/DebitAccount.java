package task2.bankingLogic;

public class DebitAccount extends BankAccount {
	private double balance;
	private int feeAmount;

	public DebitAccount(Customer owner) {
		this(owner, 1);
	}

	public DebitAccount(Customer owner, int feeAmount) {
		balance = 0;
		setFeeAmount(feeAmount);
		this.setOwner(owner);
		owner.addDebitAccount(this);
		subscribe(owner);
		notifyAll("open debit account");
	}

	public double getBalance() {
		return balance;
	}

	public int getFeeAmount() {
		return feeAmount;
	}

	public void setFeeAmount(int feeAmount) {
		if ((feeAmount >= 0) && (feeAmount <= 100)) {
			this.feeAmount = feeAmount;
		} else {
			throw new IllegalArgumentException("Unable to set fee amount: " + feeAmount + " is not a percentage");
		}
	}

	public void addMoney(double addAmount) {
		if (addAmount >= 0) {
			balance = balance + addAmount;
			notifyAll("add " + addAmount + " to debit account");
		} else {
			throw new IllegalArgumentException("Unable to add money: " + addAmount + " is a negative number");
		}
	}

	public boolean isWithdrawAvailable(double withdrawAmount) {
		if ((withdrawAmount >= 0) && (withdrawAmount + calculatePaymentFee(withdrawAmount) <= balance)) {
			return true;
		} else {
			return false;
		}
	};

	public void withdrawMoney(double withdrawAmount) {
		if (isWithdrawAvailable(withdrawAmount)) {
			notifyAll("withdraw " + withdrawAmount + " from debit account. Payment fee is "
					+ calculatePaymentFee(withdrawAmount));
			balance = balance - withdrawAmount - calculatePaymentFee(withdrawAmount);
		} else {
			throw new IllegalArgumentException("Unable to withdraw money: " + withdrawAmount + " is not acceptable");
		}
	}

	public double calculatePaymentFee(double withdrawAmount) {
		if (withdrawAmount >= 0) {
			return (double) (feeAmount * withdrawAmount) / 100;
		} else {
			throw new IllegalArgumentException(
					"Unable to calculate payment fee: " + withdrawAmount + " is a negative number");
		}

	}

	public void showAccountPlan() {
		System.out.println("This is a debit account");
		System.out.println("     owner = " + owner.getName());
		System.out.println("     balance = " + utils.Utils.doubleView(balance));
		System.out.println("     fee amount = " + feeAmount + " percent");
	}

}
