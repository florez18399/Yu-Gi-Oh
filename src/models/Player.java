package models;

import java.util.ArrayList;

public class Player {
	public final static int SIZE_CARDS_FIELD = 2;

	private int idPlayer;
	private String name;
	private int points;
	private Deck deck;
	private Hand hand;
	private Cementery cementery;
	private ArrayList<Card> cardInField;

	public Player(String name, int id) {
		System.out.println("Inicio de " + name);
		this.name = name;
		this.idPlayer = id;
		deck = new Deck();
		hand = new Hand();
		cementery = new Cementery();
		cardInField = new ArrayList<>();
	}

	public void addToHand() {
		hand.addCard(deck.getToDeck());
	}

	public void addToField(Card card) {
		if (cardInField.size() < 2) {
			hand.removeNode(card);
			cardInField.add(card);
		}
	}

	public void throwToCementery(Card card) {
		cementery.addToQueue(card);
	}

	/**
	 * @return the points
	 */
	public int getPoints() {
		return points;
	}

	/**
	 * @param points
	 *            the points to set
	 */
	public void setPoints(int points) {
		this.points = points;
	}

	/**
	 * @return the deck
	 */
	public Deck getDeck() {
		return deck;
	}

	/**
	 * @param deck
	 *            the deck to set
	 */
	public void setDeck(Deck deck) {
		this.deck = deck;
	}

	/**
	 * @return the hand
	 */
	public Hand getHand() {
		return hand;
	}

	/**
	 * @param hand
	 *            the hand to set
	 */
	public void setHand(Hand hand) {
		this.hand = hand;
	}

	/**
	 * @return the cementery
	 */
	public Cementery getCementery() {
		return cementery;
	}

	/**
	 * @param cementery
	 *            the cementery to set
	 */
	public void setCementery(Cementery cementery) {
		this.cementery = cementery;
	}

	/**
	 * @return the idPlayer
	 */
	public int getIdPlayer() {
		return idPlayer;
	}

	/**
	 * @param idPlayer
	 *            the idPlayer to set
	 */
	public void setIdPlayer(int idPlayer) {
		this.idPlayer = idPlayer;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the cardInField
	 */
	public ArrayList<Card> getCardInField() {
		return cardInField;
	}

	/**
	 * @param cardInField
	 *            the cardInField to set
	 */
	public void setCardInField(ArrayList<Card> cardInField) {
		this.cardInField = cardInField;
	}

}
