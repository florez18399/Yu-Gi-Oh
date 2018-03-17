package test;

import controller.ControllerGame;

public class RunController {
	public static void main(String[] args) {
		ControllerGame game = ControllerGame.getInstance();
		game.initGame();
	}
}
