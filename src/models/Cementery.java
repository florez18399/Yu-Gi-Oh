package models;

public class Cementery extends MyQueue<Card>{
	
	public Cementery() {
		super();
	}
	
	public void addToQueue(Card card) {
		enqueue(new Node<Card>(card));
	}
	
	public Card dequeueCard() {
		return dequeue().getInfo();
	}
}