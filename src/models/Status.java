package models;

public enum Status {
	ATTACKING("Atacando"), DEFENDING("Defendiéndose"), RESUSCITATOR("Resucitador");

	private String description;

	private Status(String description) {
		this.description = description;
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
