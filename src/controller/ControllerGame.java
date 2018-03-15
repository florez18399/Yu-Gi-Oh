package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import gui.JFrameMain;
import models.Game;

public class ControllerGame implements ActionListener {
	private static ControllerGame controllerGame;
	private Game game;
	private JFrameMain frameMain;

	private ControllerGame() {
	}

	public static ControllerGame getInstance() {
		if (controllerGame == null) {
			controllerGame = new ControllerGame();
		}
		return controllerGame;
	}

	public void initComponents() {
		game = new Game();
		frameMain = new JFrameMain(game);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String commands[] = e.getActionCommand().split("/");
		switch (Commands.valueOf(commands[0])) {
		case CHOOSE_CARD_:
			chooseCard(commands);

			break;

		case GET_CARD_OF_DECK:
			getCardOfDeck(commands);
			break;

		case THROW_CARD:
			throwCard(commands);
			break;

		case CHANGE_STATUS_CARD:
			changeStatusCard(commands);
			break;

		case ATTACK:
			attack(commands);
			break;
		default:
			break;
		}
	}

	private void changeStatusCard(String[] commands) {
		game.changeStatusCard(commands);
	}

	private void attack(String[] commands) {
		game.attackCards(Integer.parseInt(commands[1]), Integer.parseInt(commands[2]));
		frameMain.repaintComponents();
	}

	private void throwCard(String[] commands) {
		try {
			game.throwCardPlayer(commands, frameMain.getCardChoosen(Integer.parseInt(commands[1])));
		} catch (NullPointerException exception) {
			JOptionPane.showMessageDialog(frameMain, "Escoge una carta por favor", "Carta nula",
					JOptionPane.ERROR_MESSAGE);
		}
		frameMain.repaintCard(Integer.parseInt(commands[1]), null);
		frameMain.repaintComponents();
	}

	private void getCardOfDeck(String[] commands) {
		game.getCardOfDeck(commands);
		frameMain.repaintComponents();
	}

	private void chooseCard(String string[]) {
		frameMain.repaintCard(Integer.parseInt(string[1]), game.getCardOfHand(string));
	}
}
