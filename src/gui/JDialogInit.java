package gui;

import javax.swing.ImageIcon;
import javax.swing.JDialog;

public class JDialogInit extends JDialog {

	private static final long serialVersionUID = 1L;
	private JPanelAddInfo panelAddInfo;

	public JDialogInit() {
		init();
	}

	private void init() {
		setTitle(ConstantGUI.TITLE_APP);
		setIconImage(new ImageIcon(getClass().getResource(ConstantGUI.ICON_APP)).getImage());
		setSize(550, 350);
		setResizable(false);
		setLocationRelativeTo(null);
		setLayout(null);
		panelAddInfo = new JPanelAddInfo(getSize());
		add(panelAddInfo);
		setVisible(true);
	}

	public String[] getNamesPlayers() {
		System.out.println("entra enviar");
		String names[] = { panelAddInfo.getNamePlayerOne(), panelAddInfo.getNamePlayerTwo() };
		System.out.println(names.toString() + "Nombres");
		return names;
	}

}
