package controller;

public enum Commands {
	CHOOSE_CARD_("CHOOSE_CARD_", "Escoge esta carta", "Escoger esta carta de tu mano"), 
	GET_CARD_OF_DECK("GET_CARD_OF_DECK", "Obtiene una carta de la baraja","Pulsa para completar tus tres cartas"), 
	THROW_CARD("THROW_CARD", "Lanzar la carta","Lanza la carta al campo de juego"), 
	CHANGE_STATUS_CARD("CHANGE_STATUS_CARD","Cambia el estado de la carta", "Pon tu carta en ataque o en defensa, según lo necesites"),
	ATTACK("ATTACK", "Atacar", "Ataca con esta carta");

	private String command;
	private String title;
	private String description;

	private Commands(String command, String title, String description) {
		this.command = command;
		this.title = title;
		this.description = description;
	}

	/**
	 * @return the command
	 */
	public String getCommand() {
		return command;
	}

	/**
	 * @param command
	 *            the command to set
	 */
	public void setCommand(String command) {
		this.command = command;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title
	 *            the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
}
