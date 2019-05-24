package task1and2;

public class RLEDataCompression {
	public static String code(String inputString) {
		StringBuilder outputString = new StringBuilder("");
		char symbol, checkedSymbol;
		int currentPosition = 0;
		int increment;

		while (currentPosition < inputString.length()) {
			symbol = inputString.charAt(currentPosition);
			increment = 1;
			if ((Character.isDigit(symbol)) || (symbol == '\\')) {
				outputString.append("\\").append(symbol);
			} else {
				for (int checkedPosition = currentPosition + 1; checkedPosition < inputString.length(); checkedPosition++) {
					checkedSymbol = inputString.charAt(checkedPosition);
					if (symbol == checkedSymbol) {
						increment++;
					} else {
						break;
					}
				}
				outputString.append(increment).append(symbol);
			}
			currentPosition = currentPosition + increment;
		}
		return outputString.toString();
	}

	public static String decode(String inputString) {
		StringBuilder outputString = new StringBuilder("");
		StringBuilder numberToString = new StringBuilder("");
		char symbol, checkedSymbol, nextSymbol;
		int currentPosition = 0;
		int increment;
		boolean isBroken;

		while (currentPosition < inputString.length()) {
			symbol = inputString.charAt(currentPosition);
			increment = 2;
			if (symbol == '\\') {
				nextSymbol = inputString.charAt(currentPosition + 1);
				if ((Character.isDigit(nextSymbol)) || (nextSymbol == '\\')) {
					outputString.append(nextSymbol);
				} else {
					throw new IllegalArgumentException(
							"Unable to decode: string \"" + inputString + "\" is not RLE coded");
				}
			} else if (Character.isDigit(symbol)) {
				numberToString = new StringBuilder("");
				numberToString.append(symbol);
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
