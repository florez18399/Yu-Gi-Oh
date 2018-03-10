package models;

public class Hand extends MyLinkedList<Card>{
	private static final int SIZE_CARD_HAND = 3;
	
	public Hand() {
		super();
	}
	
	public void addCard(Card card){
		if(size() < SIZE_CARD_HAND) {
			addNode(new Node<Card>(card));
		}
	}
}
