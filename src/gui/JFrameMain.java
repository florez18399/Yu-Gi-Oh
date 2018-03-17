package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import models.Card;
import models.Game;

public class JFrameMain extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanelMain panelMain;
	private Game game;

	public JFrameMain(Game game) {
		this.game = game;
		init();
	}

	public void init() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(new Dimension(800, 800));
		setExtendedState(MAXIMIZED_BOTH);
		setLocationRelativeTo(null);
		setTitle(ConstantGUI.TITLE_APP);
		setIconImage(new ImageIcon(getClass().getResource(ConstantGUI.ICON_APP)).getImage());
		setLayout(new BorderLayout());
		panelMain = new JPanelMain(getSize(), game);
		add(panelMain, BorderLayout.CENTER);
		setVisible(true);
	}

	public void repaintComponents() {
		panelMain.repaintComponents();
	}

	public void repaintCard(int idPlayer, Card card) {
		panelMain.repaintCardPlayer(idPlayer, card);
	}
	
	public Card getCardChoosen(int idPlayer) {
		return panelMain.getCardChoosen(idPlayer);
	}

	public void changeTurn() {
		panelMain.changeTurn();
	}
	
}
