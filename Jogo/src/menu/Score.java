package menu;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import jogo.Game;
import javax.swing.JLayeredPane;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Score extends JFrame {

	private JPanel contentPane;
	private JLayeredPane layeredPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Score frame = new Score();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Score() {
		menu();
	}

	public void menu() {
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnNewMenu = new JMenu("Menu");
		menuBar.add(mnNewMenu);

		JMenuItem mntmNewMenuItem = new JMenuItem("New Game");
		mnNewMenu.add(mntmNewMenuItem);

		mntmNewMenuItem.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent arg0) {
				Game jogo = new Game(); 
				Score.super.setVisible(false); 

				// JanelaPontuacao login = new JanelaPontuacao(); /* instancia um novo login */
				// login.setVisible(true); /* torna o login visiavel ao usuario */
			}
		});


		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Exit");
		mnNewMenu.add(mntmNewMenuItem_1);

		mntmNewMenuItem_1.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0); 
			}
		});

		JMenu mnNewMenu_1 = new JMenu("Help");
		menuBar.add(mnNewMenu_1);

		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Welcome");
		mnNewMenu_1.add(mntmNewMenuItem_4);

		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Welcome obj = new Welcome();
				obj.main(null);
			}
		});

		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Version");
		mnNewMenu_1.add(mntmNewMenuItem_3);

		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Version obj = new Version();
				obj.main(null);
			}
		});

		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Credits");
		mnNewMenu_1.add(mntmNewMenuItem_2);

		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Credits obj = new Credits(); 
				obj.main(null);
			}
		});

	}

	public void initComponents(Map<String, String> map) {
		setTitle("Welcome");
		setResizable(false);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 423, 418);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		layeredPane = new JLayeredPane();
		layeredPane.setForeground(Color.DARK_GRAY);
		layeredPane.setBackground(new Color(0, 0, 0));
		contentPane.add(layeredPane, BorderLayout.CENTER);

		JTextArea caixaDeTexto = new JTextArea(mostrarTexto(map));
		caixaDeTexto.setForeground(Color.WHITE);
		caixaDeTexto.setBackground(Color.BLACK);
		
		JScrollPane scrollPane = new JScrollPane(caixaDeTexto);
		scrollPane.setBounds(70, 150,300, 150);
		scrollPane.setBorder(new LineBorder(Color.blue));
		layeredPane.add(scrollPane);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(37, 48, 46, 14);
		layeredPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon(Score.class.getResource("/imagens/pontos.png")));
		lblNewLabel_1.setBounds(23, 20, 364, 71);
		layeredPane.add(lblNewLabel_1);

		JButton botaoSair = new JButton("Sair");
		botaoSair.setBounds(280, 324, 89, 23);
		layeredPane.add(botaoSair);

		setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/imagens/JogoMemoria.png")));
		this.getContentPane().setBackground(Color.BLACK);

		botaoSair.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}

		});

	}
	
	public String mostrarTexto(Map<String, String> map) {
		String str = "Jogador" + "\t\t" + "Pontuacao" + "\n";

		for (String key : map.keySet()) { 
			str += ("  " + key + "\t\t" + map.get(key) + "\n");
		}

		return str;
	}
	
}