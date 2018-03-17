package gui;

import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JPanel;
import models.Card;

public class JPanelBattleField extends JPanel {

	private static final long serialVersionUID = 1L;
	private Card[] cards;
	private int idPlayer;
	private JPanelCardInField cardInField[];

	public JPanelBattleField(Card[] cards, int idPlayer) {
		this.cards = cards;
		this.idPlayer = idPlayer;
		cardInField = new JPanelCardInField[cards.length];
		init();
	}

	public void init() {
		setLayout(new FlowLayout());
		setOpaque(false);
		addPanelCards();
	}

	public void addPanelCards() {
		removeAll();
		int i = 0;
		while (i < 2) {
			if (cards[i] != null) {
				cardInField[i] = new JPanelCardInField(idPlayer, cards[i], new Dimension(250, 150));
				add(cardInField[i]);
			}
			i++;
		}
		revalidate();
	}

	public void enabledButtons() {
		for (int i = 0; i < cardInField.length; i++) {
			if (cardInField[i] != null)
				cardInField[i].enabledButton();
		}
	}
}
