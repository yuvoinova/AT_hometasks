package run;

import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import log4j.Statistics;
import person.Citizen;
import person.HumanSex;
import person.Passport;
import person.Pet;
import person.WildAnimal;

public class Main {
	public static java.util.logging.Logger logger = Logger.getLogger(Main.class.getName());


	public static void main(String[] args) {
		try {
			LogManager.getLogManager().readConfiguration(Main.class.getResourceAsStream("/logging.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		HashMap<Passport, Citizen> citizensMap = new HashMap<Passport, Citizen>();

		Scanner scan = new Scanner(System.in);
		int amountOfCitizens = scanInt(scan, "Enter amount of citizens", "amount=");
		for (int i = 0; i < amountOfCitizens; i++) {
			Citizen citizen = enterCitizen(scan, "Enter a " + (i + 1) + " citizen, ");
			Passport passport = enterPassport(scan, "Enter a passport of " + (i + 1) + " citizen");
			citizensMap.put(passport, citizen);
			Statistics.logCitizensStatistics(citizensMap);
		}

		System.out.println("Values entered:");
		for (Passport passport : citizensMap.keySet()) {
			System.out.println(citizensMap.get(passport) + ", " + passport);
		}

//		Passport passport = enterPassport(scan, "Enter a passport to search");
//		if (citizensMap.get(passport) != null) {
//			System.out.println("This passport belongs to " + citizensMap.get(passport));
//		} else {
//			System.out.println("Citizen not found");
//		}

		if (scan != null) {
			scan.close();
		}
		

	}

	private static Citizen enterCitizen(Scanner scan, String str) {
		Citizen citizen = new Citizen();
		System.out.println(str);

		System.out.print("name=");
		citizen.setName(scan.nextLine());

		System.out.print("surname=");
		citizen.setSurname(scan.nextLine());

		String humanSexStr = scanEnumValue(HumanSex.class, scan, "human sex=",
				"Incorrect input. Enter \"female\" or \"male\"");
		citizen.setHumanSex(HumanSex.valueOf(humanSexStr));

		String petStr = scanEnumValue(Pet.class, scan, "pet=",
				"Incorrect input. Just put a \'-\' if citizen does not have a pet");
		if (!petStr.equals("")) {
			citizen.setPet(Pet.valueOf(petStr));
		}

		return citizen;
	}

	private static <T extends Enum<T>> String scanEnumValue(Class<T> enumType, Scanner scan, String str1, String str2) {
		boolean isValid = false;
		boolean isWildAnimalDetected = false;
		String inputedText;

		do {
			System.out.print(str1);
			inputedText = scan.nextLine();

			isValid = isValueContainedInEnum(inputedText, enumType);

			if (isValid) {
				return inputedText.toUpperCase();
			} else if (enumType == Pet.class) {

				if (inputedText.equals("-")) {
					return "";
				}
				isWildAnimalDetected = isValueContainedInEnum(inputedText, WildAnimal.class);
				if (isWildAnimalDetected) {
					logger.warning("Incorrect input during citizen creation. Animal " + "\'" + inputedText + "\'"
							+ " is contained in enum " + WildAnimal.class.getCanonicalName() + " and is not a pet");
					System.out.println("Incorrect input. Animal " + "\'" + inputedText + "\'" + " is not a pet");
				}
			}

			if ((!isValid) && (!isWildAnimalDetected)) {
				logger.warning("Incorrect input during citizen creation. " + "\'" + inputedText + "\'"
						+ " is not contained in enum " + enumType.getCanonicalName());
				System.out.println(str2);
			}
		} while (!isValid);
		return "Something goes wrong";
	}

	private static Passport enterPassport(Scanner scan, String str) {
		Passport passport = new Passport();
		System.out.println(str);
		System.out.print("series=");
		passport.setSeries(scan.nextLine());
		System.out.print("number=");
		passport.setNumber(scan.nextLine());
		return passport;
	}

	private static int scanInt(Scanner scan, String str1, String str2) {
		int num;
		scan = new Scanner(System.in);
		System.out.println(str1);
		System.out.print(str2);
		while (!scan.hasNextInt()) {
			System.out.println(str1);
			System.out.print(str2);
			scan = new Scanner(System.in);
		}
		num = scan.nextInt();
		return num;
	}

	private static <T extends Enum<T>> boolean isValueContainedInEnum(String value, Class<T> enumType) {
		for (T enumValue : enumType.getEnumConstants()) {
			if (enumValue.name().equals(value.toUpperCase())) {
				return true;
			}
		}
		return false;
	}

}
