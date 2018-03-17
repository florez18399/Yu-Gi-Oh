package models;

public class Deck extends MyStack<Card> {
	private static final int SIZE_DECK = 20;

	public Deck() {
		fillDeckRandom();
	}

	public void addToDeck(Card card) {
		push(new Node<Card>(card));
	}

	public Card getToDeck() {
		return pop().getInfo();
	}

	public void fillDeckRandom() {
		for (int i = 0; i < SIZE_DECK; i++) {
			if (i != 5 & i != 10 & i != 15)
				addToDeck(new Card());
			else
				addToDeck(new Card(Status.RESUSCITATOR));
		}
	}
}
