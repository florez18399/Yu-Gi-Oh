package models;

public class Game {
	private Player playerOne;
	private Player playerTwo;

	public Game() {
		this.playerOne = new Player("Player1", 1);
		this.playerTwo = new Player("Player 2", 2);
	}

	/**
	 * @return the playerOne
	 */
	public Player getPlayerOne() {
		return playerOne;
	}

	/**
	 * @param playerOne
	 *            the playerOne to set
	 */
	public void setPlayerOne(Player playerOne) {
		this.playerOne = playerOne;
	}

	/**
	 * @return the playerTwo
	 */
	public Player getPlayerTwo() {
		return playerTwo;
	}

	/**
	 * @param playerTwo
	 *            the playerTwo to set
	 */
	public void setPlayerTwo(Player playerTwo) {
		this.playerTwo = playerTwo;
	}

}
