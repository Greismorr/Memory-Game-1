package menu;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Logo extends JLabel{
	
	public Logo(int xPosition, int yPosition, int width, int height) {
		this.setIcon(new ImageIcon(Credits.class.getResource("/imagens/IFBALogo.png")));
		this.setBounds(xPosition, yPosition, width, height);
	}
	
	public Logo(int xPosition, int yPosition, int width, int height, String path) {
		this.setIcon(new ImageIcon(Credits.class.getResource(path)));
		this.setBounds(xPosition, yPosition, width, height);
	}
	
}
