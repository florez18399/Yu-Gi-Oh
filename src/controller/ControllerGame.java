package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

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
		default:
			break;
		}
	}

	private void throwCard(String[] commands) {
		if (commands[1].equals("1")) {
			System.out.println("Lanza carta jugador 1");
			game.getPlayerOne().addToField(frameMain.getCardChoosen(1));
			frameMain.repaintCard(1, null);
			frameMain.repaintComponents();
		} else {
			System.out.println("Lanza carta  jugador 2");
			game.getPlayerTwo().addToField(frameMain.getCardChoosen(2));
			frameMain.repaintCard(2, null);
			frameMain.repaintComponents();
		}
	}

	private void getCardOfDeck(String[] commands) {
		if (commands[1].equals("1")) {
			game.getPlayerOne().addToHand();
			frameMain.repaintComponents();
		} else {
			game.getPlayerTwo().addToHand();
			frameMain.repaintComponents();
		}
	}

	private void chooseCard(String string[]) {
		if (string[1].equals("1")) {
			frameMain.repaintCard(1, game.getPlayerOne().getHand().get(Integer.parseInt(string[2])).getInfo());
		} else {
			frameMain.repaintCard(2, game.getPlayerTwo().getHand().get(Integer.parseInt(string[2])).getInfo());
		}
	}
}
