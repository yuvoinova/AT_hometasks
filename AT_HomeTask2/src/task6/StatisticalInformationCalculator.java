package task6;

import java.util.Scanner;

public class StatisticalInformationCalculator {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int[] data = task7.BubbleSorter.arrayEnter(scanner);
		scanner.close();
		task7.BubbleSorter.arrayPrint(data, "Array consists of such elements:");

		System.out.println("mean = " + doubleView(meanCalculator(data)));
		System.out.println("median = " + doubleView(medianCalculator(data)));
		if (isModaExisted(data)) {
			int[] modas = modaCalculator(data);
			for (int i = 0; i < modas.length; i++) {
				System.out.println("moda" + (i + 1) + " = " + modas[i]);
			}
		} else {
			System.out.println("Array doesn't have moda");
		}
		System.out.println("standard deviation = " + doubleView(standardDeviationCalculator(data)));
		modaCalculator(data);
	}

	private static double meanCalculator(int[] data) {
		int sum = 0;
		for (int i = 0; i < data.length; i++) {
			sum += data[i];
		}
		return (double) sum / data.length;
	}

	private static double medianCalculator(int[] data) {
		int[] dataSorted = data;
		task7.BubbleSorter.bubbleSort(dataSorted);
		if (dataSorted.length % 2 == 1) {
			return dataSorted[(dataSorted.length + 1) / 2];
		} else {
			return ((double) dataSorted[dataSorted.length / 2 - 1] + dataSorted[dataSorted.length / 2]) / 2;
		}
	}

	private static boolean isModaExisted(int[] data) {
		for (int i = 0; i < data.length - 1; i++) {
			for (int j = i + 1; j < data.length; j++) {
				if (data[i] == data[j]) {
					return true;
				}
			}
		}
		return false;
	}

	private static int[] modaCalculator(int[] data) { // дл€ таких вещей существуют коллекции, которые мы еще не
														// проходили
		// —читаю количество различных элементов массива, дл€ того чтобы объ€вить
		// вспомогательный массив, который € не могу объ€вить не зна€ его размера
		int dimensionDataGrouped = 1;
		int[] dataSorted = data;
		task7.BubbleSorter.bubbleSort(dataSorted);
		for (int i = 1; i < dataSorted.length; i++) {
			if (dataSorted[i] != dataSorted[i - 1]) {
				dimensionDataGrouped += 1;
			}
		}
		// —оздаю новый массив - группировка по различным значени€м и их количеству
		int[][] dataGrouped = new int[dimensionDataGrouped][2];
		int counter = 0;
		boolean isElementExisted;
		for (int i = 0; i < dataSorted.length; i++) {
			isElementExisted = false;
			for (int j = 0; j < counter; j++) {
				if (dataSorted[i] == dataGrouped[j][0]) {
					isElementExisted = true;
				}
			}
			if (!isElementExisted) {
				counter += 1;
				dataGrouped[counter - 1][0] = dataSorted[i];
				dataGrouped[counter - 1][1] = 1;
				for (int k = i + 1; k < dataSorted.length; k++) {
					if (dataSorted[k] == dataSorted[i]) {
						dataGrouped[counter - 1][1] += 1;
					}
				}

			}
		}
		// “еперь в вспомогательном массиве с количествами значений € ищу самое большое
		// количество
		int maxCount = dataGrouped[0][1];
		for (int i = 1; i < dimensionDataGrouped; i++) {
			if (dataGrouped[i][1] > maxCount) {
				maxCount = dataGrouped[i][1];
			}
		}
		// ј теперь € пытаюсь пон€ть сколько раз это самое большое количество
		// встречаетс€, ведь мод может быть несколько
		int dimention = 0;
		for (int i = 0; i < dimensionDataGrouped; i++) {
			if (dataGrouped[i][1] == maxCount) {
				dimention += 1;
			}
		}
		// “еперь € знаю размерность! (скорее всего 1(((( ) и могу получить массив мод
		counter = 0; // ≈жики плакали, кололись, но продолжали жрать кактус...
		int modas[] = new int[dimention];
		for (int i = 0; i < dimensionDataGrouped; i++) {
			if (dataGrouped[i][1] == maxCount) {
				modas[counter] = dataGrouped[i][0];
				counter += 1;
			}
		}
		return modas;
	}

	private static double standardDeviationCalculator(int[] data) {
		double sum, mean;
		mean = meanCalculator(data);
		sum = 0;
		for (int i = 0; i < data.length; i++) {
			sum += (data[i] - mean) * (data[i] - mean);
		}
		return Math.sqrt(sum / (data.length));
	}

	private static String doubleView(double arg) {
		return String.format((double) Math.round(arg * 100) / 100 + "").replaceAll("\\.0+$", "");
	}

}
