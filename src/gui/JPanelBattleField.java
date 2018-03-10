package gui;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JPanel;
import models.Card;

public class JPanelBattleField extends JPanel {

	private static final long serialVersionUID = 1L;
	private ArrayList<Card> cards;

	public JPanelBattleField(ArrayList<Card> cards) {
		this.cards = cards;
		init();
	}

	public void init() {
		setLayout(new FlowLayout());
		setOpaque(false);
		addPanelCards();
	}

	public void addPanelCards() {
		removeAll();
		for (Card card : cards) {
			JPanelCard panelCard = new JPanelCard(new Dimension(250 , 150), card);
			add(panelCard);
		}
		revalidate();
	}
}
