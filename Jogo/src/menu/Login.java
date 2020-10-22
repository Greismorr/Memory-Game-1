package menu;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import comunicacao.Client;
import jogo.Game;
import jogo.Sound;

import javax.swing.JLayeredPane;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Login extends JFrame {

	private JLabel lblCarregando;
	private JPanel loginWindow;
	private JButton playButton;
	private JLayeredPane loginPane;
	private Client cliente;
	private JTextField ipServidor;
	private JTextField portaServidor;
	private JTextField nomeJogador;
	private MenuBar menu;
	private Logo loginLogo;
	private Sound loginMusic;

	public Login() {
		initComponente();
		menu = new MenuBar(this);
		loginMusic = new Sound();
		loginMusic.mainMusic();
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void initComponente() {

		this.lblCarregando = new JLabel();
		setTitle("Jogo da Memoria - Redes");
		setResizable(false);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 565);

		loginWindow = new JPanel();
		loginWindow.setBorder(new EmptyBorder(5, 5, 5, 5));
		loginWindow.setLayout(new BorderLayout(0, 0));
		setContentPane(loginWindow);

		loginPane = new JLayeredPane();
		loginWindow.add(loginPane, BorderLayout.CENTER);

		playButton = new JButton("Jogar");
		playButton.setBounds(233, 450, 90, 30);
		loginPane.add(playButton);

		loginPane.add(loginLogo = new Logo(25, 43, 534, 190, "/imagens/testepng.png"));

		nomeJogador = new JTextField();
		nomeJogador.setColumns(10);
		nomeJogador.setBounds(204, 340, 150, 20);
		loginPane.add(nomeJogador);

		JLabel nameLabel = new JLabel("Informe seu nome:");
		nameLabel.setForeground(Color.WHITE);
		nameLabel.setBounds(204, 286, 167, 14);
		loginPane.add(nameLabel);

		setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/imagens/JogoMemoria.png")));

		this.getContentPane().setBackground(Color.BLACK);

		System.out.println(nomeJogador.getText());

		playButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					new Sound().buttonSound();
					cliente = new Client(ipServidor.getText(), Integer.parseInt(portaServidor.getText()),
							nomeJogador.getText());
					cliente.executa();
					setVisible(false);
					loginMusic.stop();
				} catch (IOException e) {
					lblCarregando.setVisible(false);
					e.printStackTrace();
				}
			}
		});
	}
	
	
	public String getIp() {
		return this.ipServidor.getText();
	}
	
	public String getPlayer() {
		return this.nomeJogador.getText();
	}
	
	public String getPort() {
		return this.ipServidor.getText();
	}
}