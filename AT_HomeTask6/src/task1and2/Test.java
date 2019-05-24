package task1and2;

import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		System.out.print("Input string for RLE coder: ");
		String str1 = scan.nextLine();
		System.out.print("Output string: " + RLEDataCompression.code(str1));
		System.out.println();
		System.out.print("Input string for RLE decoder: ");
		String str2 = scan.nextLine();
		try {
			System.out.print("Output string: " + RLEDataCompression.decode(str2));
		} catch (IllegalArgumentException iae) {
			System.out.println(iae.getMessage());
		}

		if (scan != null) {
			scan.close();
		}
	}
}
