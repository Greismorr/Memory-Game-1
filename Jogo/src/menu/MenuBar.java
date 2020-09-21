package menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import jogo.Game;

public class MenuBar{
	
	public MenuBar(JFrame mainWindow) {
		
		JMenuBar menu = new JMenuBar();
		mainWindow.setJMenuBar(menu);

		JMenu helpMenu = new JMenu("Ajuda");
		menu.add(helpMenu);

		JMenuItem aboutOption = new JMenuItem("Sobre");
		helpMenu.add(aboutOption);

		aboutOption.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				About obj = new About();
				obj.main(null);
			}
		});

		JMenuItem versionOption = new JMenuItem("Versão");
		helpMenu.add(versionOption);

		versionOption.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Version obj = new Version();
				obj.main(null);
			}
		});

		JMenuItem creditsOption = new JMenuItem("Créditos");
		helpMenu.add(creditsOption);

		creditsOption.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Credits obj = new Credits();
				obj.main(null);
			}
		});
	}
}
