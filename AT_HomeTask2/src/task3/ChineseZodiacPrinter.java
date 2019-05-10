package task3;

import java.util.Scanner;

public class ChineseZodiacPrinter {

	public static void main(String[] args) {
		int year, animalIndex, elementIndex;
		String[] animals = { "Monkey", "Rooster", "Dog", "Pig", "Rat", "Ox", "Tiger", "Rabbit", "Dragon", "Snake",
				"Horse", "Goat" };
		String[] elements = { "Metal (white)", "Water (blue)", "Wood (green)", "Fire (red)", "Earth (yellow)" };

		Scanner scanner = new Scanner(System.in);
		year = scan(scanner, "Enter a value year. It has to be an integer.", "year=");
		if (scanner != null)
			scanner.close();

		animalIndex = year % 12;
		elementIndex = (year % 10) / 2;
		System.out.println("A " + elements[elementIndex] + " " + animals[animalIndex] + " year");

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

}
