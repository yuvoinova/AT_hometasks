package task1;

public class SinglePlayingCard {
	private int rank;
	private int suit;
	private static String[] ranks = { "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King", "Ace" };
	private static String[] suits = { "clubs", "hearts", "diamonds", "spades" };

	public int getRank() {
		return rank;
	}

	public void setRank(int arg) {
		if ((arg > 5) && (arg < 15)) {
			rank = arg;
		} else {
			throw new IllegalArgumentException("rank out of bounds");
		}
	}

	public int getSuit() {
		return suit;
	}

	public void setSuit(int arg) {
		if ((arg > 0) && (arg < 5)) {
			suit = arg;
		} else {
			throw new IllegalArgumentException("suit out of bounds");
		}
	}

	public SinglePlayingCard(int rank, int suit) {
		this.setRank(rank);
		this.setSuit(suit);
	}

	public String stringView() {
		return ranks[rank - 6] + " of " + suits[suit - 1];
	}

}
