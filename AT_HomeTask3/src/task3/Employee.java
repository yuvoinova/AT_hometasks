package task3;

import java.util.ArrayList;
import java.util.Random;

public class Employee {
	private String name;
	private String surname;
	private int id;
	private static ArrayList<Integer> ids = new ArrayList<Integer>();

	public Employee() {
		Random rand = new Random();
		id = rand.nextInt(10000);
		while (ids.contains(new Integer(id))) {
			id = rand.nextInt(10000);
		}
		ids.add(id);
	}

	public Employee(String name, String surname) {
		this();
		this.name = name;
		this.surname = surname;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		if (ids.contains(new Integer(id))) {
			throw new IllegalArgumentException(
					"Unable to set id=" + id + " to employee " + this.id + ": id already exists");
		} else {
			ids.remove(new Integer(this.id));
			ids.add(id);
			this.id = id;
		}
	}

	public void print() {
		System.out.println("Employee " + id + ": " + ((name == null) ? "unknown" : name) + " "
				+ ((surname == null) ? "unknown" : surname));
	}

}
