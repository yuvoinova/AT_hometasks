package task1;

import java.util.ArrayList; // No more cactuses!
import java.util.Random;

public class Deck {
	public ArrayList<SinglePlayingCard> cards;

	public Deck() {
		SinglePlayingCard card = null;
		this.cards = new ArrayList<SinglePlayingCard>();
		for (int suit = 1; suit < 5; suit++) {
			for (int rank = 6; rank < 15; rank++) {
				try {
					card = new SinglePlayingCard(rank, suit);
				} catch (IllegalArgumentException e) {
					System.err.println("Unable to create SinglePlayingCard instance: " + e.getMessage());
				}
				cards.add(card);
			}
		}
	}

	public void show() {
		if (cards.size() > 0) {
			System.out.println("The deck consists of " + cards.size() + " cards:");
			for (SinglePlayingCard card : cards) {
				System.out.println("          " + card.stringView());
			}
		} else {
			System.out.println("The deck is empty");
		}
	}

	public void drawCard() {
		if (cards.size() > 0) {
			Random rand = new Random();
			int randomNum = rand.nextInt(cards.size());
			System.out.println("Draw a random card: " + cards.get(randomNum).stringView());
			cards.remove(randomNum);
		} else {
			System.out.println("Can't draw a card: the deck is empty");
		}
	}

}
