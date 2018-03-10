package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import Utilities.MyUtilities;
import controller.Commands;
import controller.ControllerGame;
import models.Card;
import models.Player;

public class JPanelPlayer extends JPanel {
	private static final long serialVersionUID = 1L;
	private JPanelHand panelHand;
	private JPanelCard panelCard;
	private JPanelBattleField panelBattleField;
	private Player player;

	public JPanelPlayer(Dimension dimension, Player player) {
		this.player = player;
		init(dimension);
	}

	private void init(Dimension dimension) {
		setSize(new Dimension(dimension.width / 2, dimension.height));
		setBorder(BorderFactory.createLineBorder(Color.BLUE));
		setLayout(new BorderLayout());

		JButtonDeck buttonDeck = new JButtonDeck(getSize());
		buttonDeck.addActionListener(ControllerGame.getInstance());
		buttonDeck.setActionCommand(Commands.GET_CARD_OF_DECK + "/" + player.getIdPlayer());
		add(buttonDeck, BorderLayout.EAST);
		setOpaque(false);
		addPanelCenter();

		addPanelCard();
	}

	private void addPanelCenter() {
		JPanel panelCenter = new JPanel(new GridLayout(2, 1));
		panelBattleField = new JPanelBattleField(player.getCardInField());
		panelCenter.add(panelBattleField);
		panelHand = new JPanelHand(panelCenter.getSize(), player);
		panelCenter.add(panelHand);
		panelCenter.setOpaque(false);
		add(panelCenter, BorderLayout.CENTER);
	}

	private void addPanelCard() {
		JPanel panel = new JPanel(new BorderLayout());
		panelCard = new JPanelCard(getSize());
		panel.add(panelCard, BorderLayout.CENTER);

		JButton buttonAddCard = MyUtilities.getInstance().getButton(
				Commands.THROW_CARD.getCommand() + "/" + player.getIdPlayer(), Commands.THROW_CARD.getDescription(),
				new Dimension(50, 40));
		buttonAddCard.setText(Commands.THROW_CARD.getTitle());
		buttonAddCard.addActionListener(ControllerGame.getInstance());
		buttonAddCard.setBackground(Color.RED);
		buttonAddCard.setContentAreaFilled(true);
		buttonAddCard.setForeground(Color.WHITE);
		panel.add(buttonAddCard, BorderLayout.SOUTH);
		add(panel, BorderLayout.WEST);
	}

	public void repaintComponents() {
		panelHand.addCards();
		panelBattleField.addPanelCards();
	}

	public void setCardPanel(Card card) {
		panelCard.setCard(card);
	}
	
	public Card getCardChoosen() {
		return panelCard.getCard();
	}

}
