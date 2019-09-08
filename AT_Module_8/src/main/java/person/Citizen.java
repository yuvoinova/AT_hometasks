package person;

public class Citizen {
	private String name;
	private String surname;
	private int amountOfChildren;
	private HumanSex humanSex;
	private Pet pet;	

//	public enum Pet {
//		CAT, DOG, PARROT;
//	}

	
	public Pet getPet() {
		return pet;
	}

	public void setPet(Pet pet) {
		this.pet = pet;
	}

	public HumanSex getHumanSex() {
		return humanSex;
	}

	public void setHumanSex(HumanSex humanSex) {
		this.humanSex = humanSex;
	}

	public int getAmountOfChildren() {
		return amountOfChildren;
	}

	public void setAmountOfChildren(int amountOfChildren) {
		this.amountOfChildren = amountOfChildren;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((surname == null) ? 0 : surname.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Citizen other = (Citizen) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (surname == null) {
			if (other.surname != null)
				return false;
		} else if (!surname.equals(other.surname))
			return false;
		return true;
	}

	@Override
	public String toString() {
		String humanSexStr = (humanSex != null) ? " " + humanSex.toString() : "";
		String petStr = (pet != null) ? "  pet: " + pet.toString().toLowerCase() : "";
		return "Citizen [" + name + " " + surname + humanSexStr + petStr + "]";
	}
}
