package task4;

import java.util.HashMap;
import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		HashMap<Passport,Citizen> citizensMap = new HashMap<Passport,Citizen>();
		
		Scanner scan = new Scanner(System.in);
		for (int i=0; i<3; i++) {
			Citizen citizen = enterCitizen(scan, "Enter a " + (i+1) + " citizen, ");
			Passport passport = enterPassport(scan, "Enter a passport of " + (i+1) + " citizen");
			citizensMap.put(passport,citizen);
		}
		
		System.out.println("Values entered:");
		for (Passport passport: citizensMap.keySet()) {
			System.out.println(citizensMap.get(passport) + ", " + passport);
		}
		
		Passport passport = enterPassport(scan, "Enter a passport to search");
		if (citizensMap.get(passport) != null) {
			System.out.println("This passport belongs to " + citizensMap.get(passport));
		} else {
			System.out.println("Citizen not found");
		}
		
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
		return citizen;
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

}
