package Utilities;

import java.awt.Dimension;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class MyUtilities {
	private static MyUtilities myUtilities;

	private MyUtilities() {

	}

	public final static MyUtilities getInstance() {
		if (myUtilities == null) {
			myUtilities = new MyUtilities();
		}
		return myUtilities;
	}

	public JButton getButton(String command, String description, Dimension dimension) {
		JButton button = new JButton();
		button.setPreferredSize(dimension);
		button.setBorderPainted(false);
		button.setActionCommand(command);
		button.setToolTipText(description);
		button.setContentAreaFilled(false);
		return button;
	}

	public ImageIcon getScaledInstance(Dimension dimension, String path) {
		Image image = new ImageIcon(getClass().getResource(path)).getImage();
		System.out.println(dimension.toString());
		return new ImageIcon(image.getScaledInstance((int) dimension.getWidth(), (int) dimension.getHeight(),
				Image.SCALE_REPLICATE));
	}
}
