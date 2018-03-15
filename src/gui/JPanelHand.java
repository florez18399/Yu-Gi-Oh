package gui;

import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import Utilities.MyUtilities;
import controller.Commands;
import controller.ControllerGame;
import models.Player;

public class JPanelHand extends JPanel {

	private static final long serialVersionUID = 1L;
	private Player player;

	public JPanelHand(Dimension dimension, Player player) {
		this.player = player;
		init(dimension);
	}

	private void init(Dimension dimension) {
		setLayout(new GridLayout(1, 3, 20, 20));
		setOpaque(false);
		addCards();
	}

	public void addCards() {
		removeAll();
		Dimension dimensionCards = new Dimension(this.getPreferredSize().width / 3, this.getPreferredSize().height-20);
		int i = 1;
		while (player.getHand().get(i) != null) {
			JButton buttonCard1 = MyUtilities.getInstance().getButton(
					Commands.CHOOSE_CARD_.getCommand() + "/" + player.getIdPlayer() + "/" + i,
					Commands.CHOOSE_CARD_.getDescription(), dimensionCards);
			buttonCard1.addActionListener(ControllerGame.getInstance());
			buttonCard1.setIcon(new ImageIcon(getClass().getResource(ConstantGUI.CARD_BACK_ICON)));
			add(buttonCard1);
			i++;
		}
		repaint();
		revalidate();
	}
}
