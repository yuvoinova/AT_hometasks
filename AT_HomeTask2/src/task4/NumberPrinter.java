package task4;

import java.util.Scanner;

public class NumberPrinter {
	public static void main(String[] args) {
		int number;

		Scanner scanner = new Scanner(System.in);
		do {
			number = scan(scanner, "Enter a value number. It has to be an integer from 0 to 10000", "number=");
		} while ((number < 0) || (number > 10000));
		if (scanner != null) {
			scanner.close();
		}
		System.out.println(numberView(number));

		System.out.println("Numbers from 10 to 150:");
		for (int i = 10; i <= 150; i++) {
			System.out.println(numberView(i));
		}

		System.out.println("Numbers from 9980 to 10000:");
		for (int i = 9980; i <= 10000; i++) {
			System.out.println(numberView(i));
		}
	}

	private static int scan(Scanner scanner, String str1, String str2) {
		int num;
		scanner = new Scanner(System.in);
		System.out.println(str1);
		System.out.print(str2);
		while (!scanner.hasNextInt()) {
			System.out.println(str1);
			System.out.print(str2);
			scanner = new Scanner(System.in);
		}
		num = scanner.nextInt();

		return num;
	}

	private static String numberView(int number) {
		String str = "";
		String upToAHundredStr = "";
		String hundredsStr = "";
		String thousandsStr = "";
		String[] numerals = { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten",
				"eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen" };

		thousandsStr = thousandsView(number, numerals);
		hundredsStr = hundredsView(number, numerals);
		upToAHundredStr = upToAHundredView(number, numerals);

		if (!(thousandsStr + hundredsStr).equals("") && (!upToAHundredStr.equals(""))) {
			str = thousandsStr + " " + hundredsStr + " and " + upToAHundredStr;
		} else {
			str = thousandsStr + " " + hundredsStr + " " + upToAHundredStr;
		}

		if (number == 0) {
			str = numerals[0];
		}

		return (str.trim().replaceAll("[\\s]{2,}", " "));
	}

	private static String thousandsView(int number, String[] numerals) {
		int thousands;
		String str = "";

		thousands = number / 1000;
		if (thousands != 0) {
			str = numerals[thousands] + " thousand";
		}
		return str;
	}

	private static String hundredsView(int number, String[] numerals) {
		int hundreds;
		String str = "";

		hundreds = number % 1000 / 100;
		if (hundreds != 0) {
			str = numerals[hundreds] + " hundred";
		}

		return str;
	}

	private static String upToAHundredView(int number, String[] numerals) {
		int upToAHundred;
		String str = "";

		upToAHundred = number % 100;
		if (upToAHundred >= 20) {
			switch (upToAHundred / 10) {
			case 2:
				str = "twenty";
				break;
			case 3:
				str = "thirty";
				break;
			case 4:
				str = "forty";
				break;
			case 5:
				str = "fifty";
				break;
			case 6:
				str = "sixty";
				break;
			case 7:
				str = "seventy";
				break;
			case 8:
				str = "eighty";
				break;
			case 9:
				str = "ninety";
				break;
			}
			if (upToAHundred % 10 != 0) {
				str = str + "-" + numerals[upToAHundred % 10];
			}
		} else if (upToAHundred != 0) {
			str = numerals[upToAHundred];
		}

		return str;
	}
}
