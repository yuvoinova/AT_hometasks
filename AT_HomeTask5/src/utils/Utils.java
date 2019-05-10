package utils;
import java.util.Scanner;

public final class Utils {
	public static int scanInt(Scanner scanner, String str1, String str2) {
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

	public static double scanDouble(Scanner scanner, String str1, String str2) {
		double num;
		scanner = new Scanner(System.in);
		System.out.println(str1);
		System.out.print(str2);
		while (!scanner.hasNextDouble()) {
			System.out.println(str1);
			System.out.print(str2);
			scanner = new Scanner(System.in);
		}
		num = scanner.nextDouble();

		return num;
	}
	
	public static String doubleView(double arg) {
		return String.format((double) Math.round(arg * 100) / 100 + "").replaceAll("\\.0+$", "");
	}
}
