package task3;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Employee e1 = new Employee();
		e1.print();
		Employee e2 = new Employee("Bublic", "Smith");
		e2.print();
		try {
			e1.setId(e2.getId());
		} catch (IllegalArgumentException e) {
			System.err.println(e.getMessage());
		}
		e1.setSurname(e2.getName());
		System.out.println("Enter an employee " + e1.getId() + " name");
		System.out.print("name=");
		Scanner scanner = new Scanner(System.in);
		e1.setName(scanner.nextLine());
		e1.setId(1);
		e1.print();
		e2.print();
		if (scanner != null) {
			scanner.close();
		}
	}

}
