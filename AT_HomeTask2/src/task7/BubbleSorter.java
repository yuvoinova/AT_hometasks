package task7;

import java.util.Scanner;

public class BubbleSorter {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int[] data = arrayEnter(scanner);
		scanner.close();
		arrayPrint(data, "Array consists of such elements:");
		bubbleSort(data);
		arrayPrint(data, "Sorted in ascending array is:");
		bubbleSort(data, false);
		arrayPrint(data, "Sorted in descending array is:");
	}

	private static void bubbleSort(int[] arr, boolean isAscending) {
		boolean isSorted = false;
		int buf;

		while (!isSorted) {
			isSorted = true;
			for (int i = 0; i < arr.length - 1; i++) {
				if (((arr[i] > arr[i + 1]) && (isAscending == true))
						|| ((arr[i] < arr[i + 1]) && (isAscending == false))) {
					isSorted = false;
					buf = arr[i];
					arr[i] = arr[i + 1];
					arr[i + 1] = buf;
				}
			}
		}
	}

	public static void bubbleSort(int[] arr) {
		bubbleSort(arr, true);
	}

	public static void arrayPrint(int[] arr, String str) {
		System.out.println(str);
		System.out.print("{ ");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println("}");
	}

	public static int[] arrayEnter(Scanner scanner) {
		int dimension;
		dimension = scan(scanner, "Enter a dimension of an array", "dimension=");
		int[] arr = new int[dimension];
		for (int i = 0; i < dimension; i++) {
			arr[i] = scan(scanner, "Enter " + (i + 1) + " element. It has to be an integer", "arr[" + i + "]=");
		}
		return arr;
	}

	private static int scan(Scanner scanner, String str1, String str2) {
		int num;

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
