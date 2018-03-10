package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import models.Card;
import models.Game;

public class JPanelMain extends JPanel {

	private static final long serialVersionUID = 1L;
	private JPanelPlayer panelPlayer1;
	private JPanelPlayer panelPlayer2;
	private Game game;

	public JPanelMain(Dimension dimension, Game game) {
		this.game = game;
		init(dimension);
	}

	private void init(Dimension dimension) {
		setSize(dimension);
		setBorder(BorderFactory.createLineBorder(Color.RED));
		setLayout(new GridLayout(2, 1));

		panelPlayer1 = new JPanelPlayer(getSize(), game.getPlayerOne());
		panelPlayer2 = new JPanelPlayer(getSize(), game.getPlayerTwo());

		add(panelPlayer1);
		add(panelPlayer2);

	}

	@Override
	public void paint(Graphics g) {
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Image image = toolkit.getImage(getClass().getResource(ConstantGUI.BACK2_ICON));
		setOpaque(false);
		g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), this);
		super.paint(g);
	}

	public void repaintComponents() {
		panelPlayer1.repaintComponents();
		panelPlayer2.repaintComponents();
	}

	public void repaintCardPlayer(int idPlayer, Card card) {
		if (idPlayer == 1) {
			panelPlayer1.setCardPanel(card);
		} else {
			panelPlayer2.setCardPanel(card);
		}
	}

	public Card getCardChoosen(int idPlayer) {
		if(idPlayer == 1) {
			return panelPlayer1.getCardChoosen();
		}else {
			return panelPlayer2.getCardChoosen();
		}
	}

}
