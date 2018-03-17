package gui;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

import controller.Commands;
import controller.ControllerGame;

public class JPopUpMenuStatusCard extends JPopupMenu {

	private static final long serialVersionUID = 1L;
	private JMenu menu;

	public JPopUpMenuStatusCard(int idPlayer, int idCard) {
		menu = new JMenu("Cambia el estado de esta carta");
		init(idPlayer, idCard);
	}

	private void init(int idPlayer, int idCard) {
		JMenuItem itemAttack = new JMenuItem("!ATAQUE!");
		itemAttack.setActionCommand(Commands.CHANGE_STATUS_CARD.getCommand() + "/" + idPlayer + "/" + idCard + "/" + 1);
		itemAttack.addActionListener(ControllerGame.getInstance());
		menu.add(itemAttack);
		menu.addSeparator();
		JMenuItem itemDefense = new JMenuItem("!DEFENSA!");
		itemDefense.setActionCommand(Commands.CHANGE_STATUS_CARD.getCommand() + "/" + idPlayer + "/" + idCard + "/" + 2);
		itemDefense.addActionListener(ControllerGame.getInstance());
		menu.add(itemDefense);
		add(menu);
	}

}
