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
	private Card[] cardInField;

	public Player(String name, int id) {
		System.out.println("Inicio de " + name);
		this.name = name;
		this.idPlayer = id;
		this.points = 2000;
		deck = new Deck();
		hand = new Hand();
		cementery = new Cementery();
		cardInField = new Card[2];
	}

	public void addToHand() {
		hand.addCard(deck.getToDeck());
	}

	public void addToField(Card card) {
		if (cardInField[0] == null) {
			hand.removeNode(card);
			card.setIdCard((byte) 0);
			if (!card.getStatusCard().equals(Status.RESUSCITATOR)) {
				cardInField[0] = card;
			} else {
				cardInField[0] = cementery.dequeueCard();
			}
		} else if (cardInField[1] == null) {
			hand.removeNode(card);
			card.setIdCard((byte) 1);
			if (!card.getStatusCard().equals(Status.RESUSCITATOR)) {
				cardInField[1] = card;
			} else {
				cardInField[1] = cementery.dequeueCard();
			}
		}
	}

	public void addIdCard() {
		int i = 0;
		for (Card card : cardInField) {
			System.out.println("Id de carta: " + i);
			card.setIdCard((byte) i);
			i++;
		}
	}

	/**
	 * 
	 * @return la carta que se encuentra en el campo de batalla y que tiene el id
	 *         especificado
	 */
	public Card getCardId(int id) {
		for (Card card : cardInField) {
			if (card.getIdCard() == id)
				return card;
		}
		return null;
	}

	public void throwToCementery(Card card) {
		cardInField[card.getIdCard()] = null;
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
	public Card[] getCardInField() {
		return cardInField;
	}

}
