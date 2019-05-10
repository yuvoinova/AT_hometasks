package task1;

import java.util.Scanner;

public class PrimeNumbersPrinter {

	public static void main(String[] args) {
		long from, to, previousNumber;
		boolean isPrime;

		Scanner scanner = new Scanner(System.in);
		from = scan(scanner, "Enter value from. It has to be a number.", "from=");
		do {
			to = scan(scanner, "Enter value to. It has to be a number greater than from", "to=");
		} while (to <= from);
		if (scanner != null)
			scanner.close();

		for (long currentNumber = Math.max(2, from); currentNumber <= to; currentNumber++) {
			isPrime = true;
			previousNumber = 1;
			do {
				if ((currentNumber % previousNumber == 0) && (previousNumber != 1)) {
					isPrime = false;
				}
				previousNumber++;
			} while ((isPrime == true) && (currentNumber != previousNumber));
			if (isPrime == true) {
				System.out.print(currentNumber + " ");
			}
		}
	}

	private static long scan(Scanner scanner, String str1, String str2) {
		long num;
		scanner = new Scanner(System.in);
		System.out.println(str1);
		System.out.print(str2);
		while (!scanner.hasNextLong()) {
			System.out.println(str1);
			System.out.print(str2);
			scanner = new Scanner(System.in);
		}
		num = scanner.nextLong();

		return num;
	}
}