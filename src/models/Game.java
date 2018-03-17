package models;

public class Game {
	private Player playerOne;
	private Player playerTwo;

	public Game() {
		this.playerOne = new Player("Player1", 1);
		this.playerTwo = new Player("Player 2", 2);
	}

	public Game(String[] names) {
		this.playerOne = new Player(names[0], 1);
		this.playerTwo = new Player(names[1], 2);
	}

	public void attackCards(int idAttackPlayer, int idCard) {
		Player attackPlayer;
		Player defensePlayer;
		if (idAttackPlayer == 1) {
			attackPlayer = playerOne;
			defensePlayer = playerTwo;
		} else {
			attackPlayer = playerTwo;
			defensePlayer = playerOne;
		}
		Card attackCard = attackPlayer.getCardInField()[idCard];
		Card defenseCard = defensePlayer.getCardInField()[idCard];
		attackCard.setStatusCard(Status.ATTACKING);
		if (defenseCard.getStatusCard().equals(Status.DEFENDING)) {
			if (defenseCard.getDefense() < attackCard.getAttack()) 
				defensePlayer.throwToCementery(defenseCard);
			 else 
				attackPlayer.setPoints(attackPlayer.getPoints() - (defenseCard.getDefense() - attackCard.getAttack()));
		} else {
			if (defenseCard.getAttack() < attackCard.getAttack())
				defensePlayer.throwToCementery(defenseCard);
			else 
				attackPlayer.throwToCementery(attackCard);
		}
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

	public void changeStatusCard(String[] commands) {
		Player player = getPlayerforId(Integer.parseInt(commands[1]));
		if (commands[3].equals("1"))
			player.getCardInField()[Integer.parseInt(commands[2])].setStatusCard(Status.ATTACKING);
		else
			player.getCardInField()[Integer.parseInt(commands[2])].setStatusCard(Status.DEFENDING);
	}

	public Player getPlayerforId(int id) {
		return id == 1 ? playerOne : playerTwo; 
	}

	public void getCardOfDeck(String[] commands) {
		getPlayerforId(Integer.parseInt(commands[1])).addToHand();
	}

	public Card getCardOfHand(String[] string) {
		return getPlayerforId(Integer.parseInt(string[1])).getHand().get(Integer.parseInt(string[2])).getInfo();
	}

	public void throwCardPlayer(String[] commands, Card cardChoosen) {
		if(cardChoosen != null) {
			getPlayerforId(Integer.parseInt(commands[1])).addToField(cardChoosen);
		}else {
			throw new NullPointerException();
		}
	}
}
