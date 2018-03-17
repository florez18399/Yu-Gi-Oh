package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import controller.Commands;
import controller.ControllerGame;
import models.Card;

public class JPanelCardInField extends JPanel {
	private static final long serialVersionUID = 1L;
	private int idPlayer;
	private Card card;
	private JButton buttonAttack;

	public JPanelCardInField(int idPlayer, Card card, Dimension dimension) {
		this.card = card;
		this.idPlayer = idPlayer;
		init(dimension);
	}

	private void init(Dimension dimension) {
		Dimension dimensionCards = new Dimension((int)dimension.getWidth(), (int)dimension.getHeight()-40);
		setSize(dimension);
		setPreferredSize(dimension);
		setOpaque(false);
		setLayout(new FlowLayout());
		add(new JPanelCard(dimensionCards, card, idPlayer), BorderLayout.CENTER);

		buttonAttack = new JButton(Commands.ATTACK.getTitle());
		buttonAttack.setBackground(Color.BLACK);
		buttonAttack.setBorderPainted(false);
		buttonAttack.setForeground(Color.WHITE);
		buttonAttack.setFont(new Font("Times New Roman", Font.CENTER_BASELINE, 15));
		buttonAttack.setIcon(new ImageIcon(getClass().getResource("/images/attack.png")));
		buttonAttack.setFocusable(true);
		buttonAttack.setPreferredSize(new Dimension((int)dimension.getWidth()/2, 30));
		buttonAttack.setActionCommand(Commands.ATTACK.getCommand() + "/" + idPlayer + "/" + card.getIdCard());
		buttonAttack.addActionListener(ControllerGame.getInstance());
		add(buttonAttack);
	}
	
	public void enabledButton() {
		buttonAttack.setEnabled(!buttonAttack.isEnabled());
	}
}
