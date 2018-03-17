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
		fillId();
	}
	
	public void fillId() {
		for (int i = 0; i < size()-1; i++) {
			System.out.println("id" + i);
			get(i).getInfo().setIdCard((byte)i);
		}	
	}
}
