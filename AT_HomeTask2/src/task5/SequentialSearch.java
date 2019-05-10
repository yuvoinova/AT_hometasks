package task5;

import java.util.Scanner;

public class SequentialSearch {

	public static void main(String[] args) {
		int element, position;
		Scanner scanner = new Scanner(System.in);
		int[] arr = task7.BubbleSorter.arrayEnter(scanner);
		task7.BubbleSorter.arrayPrint(arr, "Array consists of such elements:");

		element = scan(scanner, "Enter an element to search. It has to be an integer", "element=");
		scanner.close();

		position = sequentialSearcher(arr, element);
		if (position != -1) {
			System.out.println("The element has been founded. It is " + position + " element of array");
		} else {
			System.out.println("The element has not been founded");
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

	private static int sequentialSearcher(int[] arr, int element) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == element) {
				return i + 1;
			}
		}
		return -1;
	}

}
