package gui;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JPanel;
import models.Card;
import models.Status;

public class JPanelCard extends JPanel {

	private static final long serialVersionUID = 1L;
	private Card card;

	public JPanelCard(Dimension dimension, int idPlayer) {
		init(dimension, idPlayer);
	}

	public JPanelCard(Dimension dimension, Card card, int idPlayer) {
		this.card = card;
		init(dimension, idPlayer);
	}

	private void init(Dimension dimension, int idPlayer) {
		Dimension myDimension = new Dimension((int) dimension.getWidth() / 2, (int) dimension.getHeight());
		setSize(myDimension);
		setPreferredSize(myDimension);
		if(card != null) {
			setComponentPopupMenu(new JPopUpMenuStatusCard(idPlayer, card.getIdCard()));
		}
	}

	@Override
	public void paint(Graphics g) {
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Image image = toolkit.getImage(getClass().getResource(ConstantGUI.CARD_EMPTY_ICON1));
		g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), this);
		drawCardData(g);
		setOpaque(false);
		super.paint(g);
	}

	private void drawCardData(Graphics graphics) {
		if (card != null) {
			if(!card.getStatusCard().equals(Status.RESUSCITATOR)) {
				graphics.drawString("Ataque: " + card.getAttack(), getWidth() / 4, getHeight() * 2 / 5);
				graphics.drawString("Defensa: " + card.getDefense(), getWidth() / 4, getHeight() * 3 / 5);
			}else {
				graphics.drawString("! CARTA", getWidth() / 5,getHeight() * 2 / 5);
				graphics.drawString("RESUSCITADORA !", getWidth() / 5,getHeight() * 3 / 5);
			}
		}
	}

	/**
	 * @return the card
	 */
	public Card getCard() {
		return card;
	}

	/**
	 * @param card
	 *            the card to set
	 */
	public void setCard(Card card) {
		this.card = card;
		repaint();
	}

}
