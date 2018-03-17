package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Toolkit;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

import Utilities.MyUtilities;
import controller.Commands;
import controller.ControllerGame;

public class JPanelAddInfo extends JPanel {
	private static final long serialVersionUID = 1L;
	private JTextField fieldNamePlayerOne;
	private JTextField fieldNamePlayerTwo;

	public JPanelAddInfo(Dimension dimension) {
		init(dimension);
	}

	private void init(Dimension s) {
		setSize(s);
		setPreferredSize(s);
		setLayout(new FlowLayout());
		setOpaque(false);
		JLabel label = new JLabel("YU-GI-OH");
		label.setFont(new Font("Times New Roman", Font.ITALIC, 70));
		label.setForeground(Color.WHITE);
		add(label);
		Dimension myDimension = new Dimension(getWidth() - 50, 50);

		Border myBorder = BorderFactory.createLineBorder(Color.RED);
		fieldNamePlayerOne = new JTextField();
		fieldNamePlayerOne.setBorder(BorderFactory.createTitledBorder(myBorder, "Nombre jugador 1: "));
		fieldNamePlayerOne.setPreferredSize(myDimension);
		add(fieldNamePlayerOne);
		fieldNamePlayerTwo = new JTextField();
		fieldNamePlayerTwo.setPreferredSize(myDimension);
		fieldNamePlayerTwo.setBorder(BorderFactory.createTitledBorder(myBorder, "Nombre jugador 2: "));
		add(fieldNamePlayerTwo);

		JButton button = MyUtilities.getInstance().getButton(Commands.INIT_BATTLE.getCommand(),
				Commands.INIT_BATTLE.getDescription(), new Dimension(200, 30));
		button.setText(Commands.INIT_BATTLE.getTitle());
		button.setIcon(new ImageIcon(getClass().getResource("/images/sword.png")));
		button.addActionListener(ControllerGame.getInstance());
		button.setForeground(Color.WHITE);
		add(button);
		repaint();
		revalidate();
	}

	public String getNamePlayerOne() {
		return fieldNamePlayerOne.getText();
	}

	public String getNamePlayerTwo() {
		return fieldNamePlayerTwo.getText();
	}

	@Override
	public void paint(Graphics graphics) {
		graphics.drawImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource(ConstantGUI.BACK1_ICON)), 0, 0,
				getWidth(), getHeight(), this);
		super.paint(graphics);
	}
}
