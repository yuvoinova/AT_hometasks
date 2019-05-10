package task1;

public class MainClass {

	public static void main(String[] args) {
		Deck deck = new Deck();
		deck.show();
		while (deck.cards.size() > 0) {
			deck.drawCard();
		}
		deck.show();
	}

}
