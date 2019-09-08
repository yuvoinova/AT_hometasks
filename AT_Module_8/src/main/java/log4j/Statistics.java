package log4j;

import java.util.HashMap;

import org.apache.log4j.Logger;

import person.Citizen;
import person.Passport;
import person.Pet;
import run.Main;

public class Statistics {
	public static Logger logger = org.apache.log4j.Logger.getLogger(Main.class.getName());

	
	public static void logCitizensStatistics(HashMap<Passport, Citizen> citizensMap) {
		StringBuilder msg = new StringBuilder("Amount of citizens: " + citizensMap.size() + ". ");
		int amountOfCat = countPet(citizensMap, Pet.CAT);
		msg.append(amountOfCat + " with cats and ");
		int amountOfDog = countPet(citizensMap, Pet.DOG);
		msg.append(amountOfDog + " with dogs.");
		if (amountOfCat > amountOfDog) {
			msg.append(" Cat people win");
		} else if (amountOfDog > amountOfCat) {
			msg.append(" Dog people win");
		}
		logger.log(MyLevel.STATISTICS, msg.toString());
	}

	private static int countPet(HashMap<Passport, Citizen> citizensMap, Pet pet) {
		int countPet = 0;
		for (Citizen citizen : citizensMap.values()) {
			if (citizen.getPet() == pet) {
				countPet += 1;
			}
		}
		return countPet;
	}


}
