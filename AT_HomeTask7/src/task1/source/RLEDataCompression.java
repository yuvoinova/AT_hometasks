package task1.source;

public class RLEDataCompression {
	public static String code(String inputString) {
		StringBuilder outputString = new StringBuilder("");
		char currentSymbol, checkedSymbol;
		int currentPosition = 0;
		int increment;

		while (currentPosition < inputString.length()) {
			currentSymbol = inputString.charAt(currentPosition);
			increment = 1;
			if ((Character.isDigit(currentSymbol)) || (currentSymbol == '\\')) {
				outputString.append("\\").append(currentSymbol);
			} else {
				for (int checkedPosition = currentPosition + 1; checkedPosition < inputString.length(); checkedPosition++) {
					checkedSymbol = inputString.charAt(checkedPosition);
					if (currentSymbol == checkedSymbol) {
						increment++;
					} else {
						break;
					}
				}
				outputString.append(increment).append(currentSymbol);
			}
			currentPosition = currentPosition + increment;
		}
		return outputString.toString();
	}

	public static String decode(String inputString) {
		StringBuilder outputString = new StringBuilder("");
		StringBuilder numberToString = new StringBuilder("");
		char currentSymbol, checkedSymbol, nextSymbol;
		int currentPosition = 0;
		int increment;
		boolean isBroken;

		while (currentPosition < inputString.length()) {
			currentSymbol = inputString.charAt(currentPosition);
			increment = 2;
			if (currentSymbol == '\\') {
				nextSymbol = inputString.charAt(currentPosition + 1);
				if ((Character.isDigit(nextSymbol)) || (nextSymbol == '\\')) {
					outputString.append(nextSymbol);
				} else {
					throw new IllegalArgumentException(
							"Unable to decode: string \"" + inputString + "\" is not RLE coded");
				}
			} else if (Character.isDigit(currentSymbol)) {
				numberToString = new StringBuilder("");
				numberToString.append(currentSymbol);
				isBroken = false;
				for (int checkedPosition = currentPosition + 1; checkedPosition < inputString.length(); checkedPosition++) {
					checkedSymbol = inputString.charAt(checkedPosition);
					if (Character.isDigit(checkedSymbol)) {
						increment++;
						numberToString.append(checkedSymbol);
					} else {
						isBroken = true;
						break;
					}
				}

				if (isBroken) {
					nextSymbol = inputString.charAt(currentPosition + increment - 1);
					for (int i = 0; i < Integer.parseInt(numberToString.toString()); i++) {
						outputString.append(nextSymbol);
					}
				} else {
					throw new IllegalArgumentException(
							"Unable to decode: string \"" + inputString + "\" is not RLE coded");

				}
			} else {
				throw new IllegalArgumentException("Unable to decode: string \"" + inputString + "\" is not RLE coded");
			}
			currentPosition = currentPosition + increment;
		}
		return outputString.toString();
	}

}
