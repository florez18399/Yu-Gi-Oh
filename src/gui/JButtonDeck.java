package gui;

import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import Utilities.MyUtilities;

public class JButtonDeck extends JButton {

	private static final long serialVersionUID = 1L;

	public JButtonDeck(Dimension dimension) {
		init(dimension);
	}

	private void init(Dimension dimension) {
		Dimension myDimension = new Dimension((int) dimension.getWidth() / 2, (int) dimension.getHeight() / 4);
		ImageIcon imageIcon = MyUtilities.getInstance().getScaledInstance(myDimension, ConstantGUI.DECK_ICON);
		setIcon(imageIcon);
		setPreferredSize(myDimension);
		setContentAreaFilled(false);
		setBorderPainted(false);
	}

}
