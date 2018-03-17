package models;

public class Card {
	private String nameMonster;
	private int attack;
	private int defense;
	private Status statusCard;
	private byte idCard;

	public Card(String nameMonster, int attack, int defense) {
		this.nameMonster = nameMonster;
		this.attack = attack;
		this.defense = defense;
	}

	public Card() {
		nameMonster = "Carta";
		attack = (int) (Math.random() * 100);
		defense = (int) (Math.random() * 100);
		this.statusCard = Status.ATTACKING;
	}

	public Card(Status status) {
		this.statusCard = status;
	}

	public void showCardData() {
		System.out.println("Nombre del monstruo: " + nameMonster);
		System.out.println("Ataque del monstruo: " + attack);
		System.out.println("Defensa del monstruo: " + defense);
	}

	/**
	 * @return the nameMonster
	 */
	public String getNameMonster() {
		return nameMonster;
	}

	/**
	 * @param nameMonster
	 *            the nameMonster to set
	 */
	public void setNameMonster(String nameMonster) {
		this.nameMonster = nameMonster;
	}

	/**
	 * @return the attack
	 */
	public int getAttack() {
		return attack;
	}

	/**
	 * @param attack
	 *            the attack to set
	 */
	public void setAttack(int attack) {
		this.attack = attack;
	}

	/**
	 * @return the defense
	 */
	public int getDefense() {
		return defense;
	}

	/**
	 * @param defense
	 *            the defense to set
	 */
	public void setDefense(int defense) {
		this.defense = defense;
	}

	/**
	 * @return the statusCard
	 */
	public Status getStatusCard() {
		return statusCard;
	}

	/**
	 * @param statusCard
	 *            the statusCard to set
	 */
	public void setStatusCard(Status statusCard) {
		this.statusCard = statusCard;
	}

	/**
	 * @return the idCard
	 */
	public byte getIdCard() {
		return idCard;
	}

	/**
	 * @param idCard
	 *            the idCard to set
	 */
	public void setIdCard(byte idCard) {
		this.idCard = idCard;
	}

}
