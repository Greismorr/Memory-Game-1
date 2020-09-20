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
	private JPanel contentPane;
	private JButton btnJogar;
	private JLayeredPane layeredPane;
	private Client cliente;
	private JTextField ipServidor;
	private JTextField portaServidor;
	private JTextField nomeJogador;

	public Login() {
		initComponente();
		menu();
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

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		layeredPane = new JLayeredPane();
		contentPane.add(layeredPane, BorderLayout.CENTER);

		btnJogar = new JButton("Jogar");
		btnJogar.setBounds(233, 450, 90, 30);
		layeredPane.add(btnJogar);

		ipServidor = new JTextField();
		ipServidor.setColumns(10);
		ipServidor.setBounds(204, 299, 150, 20);
		layeredPane.add(ipServidor);

		JLabel lblEntreComIp = new JLabel("Entre com IP do servidor:");
		lblEntreComIp.setBounds(204, 274, 154, 14);
		layeredPane.add(lblEntreComIp);
		lblEntreComIp.setForeground(Color.white);

		portaServidor = new JTextField();
		portaServidor.setColumns(10);
		portaServidor.setBounds(204, 355, 150, 20);
		layeredPane.add(portaServidor);

		JLabel lblEntreComA = new JLabel("Entre com a porta:");
		lblEntreComA.setBounds(204, 330, 167, 14);
		layeredPane.add(lblEntreComA);
		lblEntreComA.setForeground(Color.white);

		JLabel lblNewLabel_1 = new JLabel("");

		lblNewLabel_1.setIcon(new ImageIcon(Login.class.getResource("/imagens/testepng.png")));
		lblNewLabel_1.setBounds(25, 43, 534, 190);
		layeredPane.add(lblNewLabel_1);

		nomeJogador = new JTextField();
		nomeJogador.setColumns(10);
		nomeJogador.setBounds(204, 411, 150, 20);
		layeredPane.add(nomeJogador);

		JLabel lblInformeSeuNome = new JLabel("Informe seu nome:");
		lblInformeSeuNome.setForeground(Color.WHITE);
		lblInformeSeuNome.setBounds(204, 386, 167, 14);
		layeredPane.add(lblInformeSeuNome);

		setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/imagens/JogoMemoria.png")));

		this.getContentPane().setBackground(Color.BLACK);

		System.out.println(nomeJogador.getText());

		btnJogar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					new Sound().selecionado();
					cliente = new Client(ipServidor.getText(), Integer.parseInt(portaServidor.getText()),
							nomeJogador.getText());
					cliente.executa();
				} catch (IOException e) {
					lblCarregando.setVisible(false);
					e.printStackTrace();
				}
			}
		});

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
				Login.super.setVisible(false);

				Login login = new Login();
				login.setVisible(true);
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

}