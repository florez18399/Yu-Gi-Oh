package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;
import models.Player;

public class JPanelInfoPlayer extends JPanel {

	private static final long serialVersionUID = 1L;
	private Player player;
	private JLabel labelPoints;

	public JPanelInfoPlayer(Player player, Dimension dimension) {
		this.player = player;
		init(dimension);
	}

	public void init(Dimension dimension) {
		setSize((int) dimension.getWidth(), 30);
		Dimension myDimension = new Dimension(300, getHeight());
		setOpaque(false);
		setLayout(new FlowLayout());
		Font font = new Font("Times New Roman", Font.ITALIC, 25);
		JLabel labelName = new JLabel(player.getName());
		labelName.setFont(font);
		labelName.setForeground(Color.WHITE);
		labelName.setPreferredSize(myDimension);
		add(labelName);
		labelPoints = new JLabel("Puntos: " + player.getPoints());
		labelPoints.setFont(font);
		labelPoints.setForeground(Color.WHITE);
		labelPoints.setPreferredSize(myDimension);
		add(labelPoints);
	}

	public void repaintPoints() {
		labelPoints.setText("Puntos: " + player.getPoints());
		repaint();
	}
}
