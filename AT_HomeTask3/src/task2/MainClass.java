package task2;

import java.util.Scanner;

public class MainClass {
	public static void main(String[] args) {
		int numberOfWorkingHours;
		double perHourPayment, calculatedPayment;

		Scanner scanner = new Scanner(System.in);
		do {
			numberOfWorkingHours = utils.Utils.scanInt(scanner,
					"Enter a number of working hours. It has to be a non-negative integer", "number=");
		} while (numberOfWorkingHours < 0);

		do {
			perHourPayment = utils.Utils.scanDouble(scanner,
					"Enter a per hour payment. It has to be a number greater than 0", "payment=");
		} while (perHourPayment <= 0);
		if (scanner != null) {
			scanner.close();
		}

		calculatedPayment = Accounting.pay(numberOfWorkingHours, perHourPayment);
		System.out.println("Calculated payment = " + utils.Utils.doubleView(calculatedPayment));
	}

}
