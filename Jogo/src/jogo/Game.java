package jogo;

import java.awt.Color;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Game extends javax.swing.JFrame {

	ArrayList<GameFacil> cartas = new ArrayList<GameFacil>();

	private javax.swing.JMenuBar barraDeMenu;
	private javax.swing.JLabel labelCartasViradas;
	private javax.swing.JLabel labelPontos;
	private javax.swing.JLabel labelPontuacao;
	private javax.swing.JLabel labelQuantDeCartasViradas2;
	private javax.swing.JMenu menuJogo;
	private javax.swing.JPanel painelPrincipal;
	private javax.swing.JMenuItem subMenuDeJogo_NovoJogo;
	private javax.swing.JMenuItem subMenuDeJogo_Opcoes;
	private javax.swing.JMenuItem subMenuDeJogo_Sair;

	public Game() {
		initComponents();

		Random gerador = new Random();
		int num = gerador.nextInt(7);

		Sound musica = new Sound();
		musica.music(num);

		GameFacil carta1 = new GameFacil("/imagens/ethernet.png", labelPontuacao, labelQuantDeCartasViradas2,
				subMenuDeJogo_NovoJogo);
		GameFacil carta2 = new GameFacil("/imagens/resEthernet.png", labelPontuacao, labelQuantDeCartasViradas2,
				subMenuDeJogo_NovoJogo);
		GameFacil carta3 = new GameFacil("/imagens/firewall.png", labelPontuacao, labelQuantDeCartasViradas2,
				subMenuDeJogo_NovoJogo);
		GameFacil carta4 = new GameFacil("/imagens/resFirewall.png", labelPontuacao, labelQuantDeCartasViradas2,
				subMenuDeJogo_NovoJogo);
		GameFacil carta6 = new GameFacil("/imagens/modem.png", labelPontuacao, labelQuantDeCartasViradas2,
				subMenuDeJogo_NovoJogo);
		GameFacil carta7 = new GameFacil("/imagens/resModem.png", labelPontuacao, labelQuantDeCartasViradas2,
				subMenuDeJogo_NovoJogo);
		GameFacil carta8 = new GameFacil("/imagens/noBreak.png", labelPontuacao, labelQuantDeCartasViradas2,
				subMenuDeJogo_NovoJogo);
		GameFacil carta9 = new GameFacil("/imagens/resNobreak.png", labelPontuacao, labelQuantDeCartasViradas2,
				subMenuDeJogo_NovoJogo);
		GameFacil carta10 = new GameFacil("/imagens/repetidor.png", labelPontuacao, labelQuantDeCartasViradas2,
				subMenuDeJogo_NovoJogo);
		GameFacil carta11 = new GameFacil("/imagens/resRepetidor.png", labelPontuacao, labelQuantDeCartasViradas2,
				subMenuDeJogo_NovoJogo);
		GameFacil carta12 = new GameFacil("/imagens/roteador.png", labelPontuacao, labelQuantDeCartasViradas2,
				subMenuDeJogo_NovoJogo);
		GameFacil carta13 = new GameFacil("/imagens/resRoteador.png", labelPontuacao, labelQuantDeCartasViradas2,
				subMenuDeJogo_NovoJogo);
		GameFacil carta14 = new GameFacil("/imagens/servidores.png", labelPontuacao, labelQuantDeCartasViradas2,
				subMenuDeJogo_NovoJogo);
		GameFacil carta5 = new GameFacil("/imagens/resServidores.png", labelPontuacao, labelQuantDeCartasViradas2,
				subMenuDeJogo_NovoJogo);
		GameFacil carta15 = new GameFacil("/imagens/switch.png", labelPontuacao, labelQuantDeCartasViradas2,
				subMenuDeJogo_NovoJogo);
		GameFacil carta16 = new GameFacil("/imagens/resSwitch.png", labelPontuacao, labelQuantDeCartasViradas2,
				subMenuDeJogo_NovoJogo);

		cartas.add(carta1);
		cartas.add(carta2);
		cartas.add(carta3);
		cartas.add(carta4);
		cartas.add(carta5);
		cartas.add(carta6);
		cartas.add(carta7);
		cartas.add(carta8);
		cartas.add(carta9);
		cartas.add(carta10);
		cartas.add(carta11);
		cartas.add(carta12);
		cartas.add(carta13);
		cartas.add(carta14);
		cartas.add(carta15);
		cartas.add(carta16);

		/* Definindo os pares das cartas em relacao da primeira para a segunda */
		carta1.setPar(carta2);
		carta3.setPar(carta4);
		carta6.setPar(carta7);
		carta8.setPar(carta9);
		carta10.setPar(carta11);
		carta12.setPar(carta13);
		carta14.setPar(carta5);
		carta15.setPar(carta16);

		/* Definindo os pares das cartas em relacao da segunda para a primeira */
		carta2.setPar(carta1);
		carta4.setPar(carta3);
		carta7.setPar(carta6);
		carta9.setPar(carta8);
		carta11.setPar(carta10);
		carta13.setPar(carta12);
		carta5.setPar(carta14);
		carta16.setPar(carta15);

		Collections.shuffle(cartas);

		for (GameFacil c : cartas) {
			c.esconderCarta();
			painelPrincipal.add(c);
		}
	}

	private void initComponents() {

		labelPontos = new javax.swing.JLabel();
		labelPontuacao = new javax.swing.JLabel();
		labelCartasViradas = new javax.swing.JLabel();
		labelQuantDeCartasViradas2 = new javax.swing.JLabel();
		painelPrincipal = new javax.swing.JPanel();
		barraDeMenu = new javax.swing.JMenuBar();
		menuJogo = new javax.swing.JMenu();
		subMenuDeJogo_NovoJogo = new javax.swing.JMenuItem();
		subMenuDeJogo_Opcoes = new javax.swing.JMenuItem();
		subMenuDeJogo_Sair = new javax.swing.JMenuItem();

		// setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setTitle("Jogo da Memoria Redes");
		setResizable(false);

		this.getContentPane().setBackground(Color.gray);
		setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/imagens/JogoMemoria.png")));

		labelPontos.setText("Pontos:");
		labelPontuacao.setText("0");
		labelCartasViradas.setText("Cartas Viradas:");
		labelQuantDeCartasViradas2.setText("0");

		painelPrincipal.setLayout(new java.awt.GridLayout(4, 4));
		this.painelPrincipal.setBackground(Color.gray);

		menuJogo.setText("Jogo");

		subMenuDeJogo_NovoJogo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F2, 0));
		subMenuDeJogo_NovoJogo.setText("Novo Jogo");

		subMenuDeJogo_NovoJogo.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				SubMenuDeJogo_NovoJogoActionPerformed(evt);
			}
		});

		menuJogo.add(subMenuDeJogo_NovoJogo); /* Adiciona no menu a opcao de novo jogo */
		subMenuDeJogo_Sair.setText("Sair"); /* seta o titulo de Sair */

		subMenuDeJogo_Sair.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				System.exit(0);
			}
		});

		menuJogo.add(subMenuDeJogo_Sair);
		barraDeMenu.add(menuJogo);
		setJMenuBar(barraDeMenu);

		/* agrupamento hierarquico dos componentes em um container */
		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup( /*
									 * Define o Group que posiciona e dimensiona componentes ao longo do eixo
									 * horizontal.
									 */
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING) /*
																						 * Cria e retorna um
																						 * ParallelGroup com um
																						 * alinhamento de
																						 * Alignment.LEADING
																						 */
						.addGroup(layout.createSequentialGroup() /* cria um grupo sequencia */
								.addContainerGap()
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addGroup(layout.createSequentialGroup() /* cria um grupo sequencia */
												.addComponent(painelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE,
														627, Short.MAX_VALUE)
												.addContainerGap())
										.addGroup(layout.createSequentialGroup() /* cria um grupo sequencia */
												.addComponent(labelPontos)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
												.addComponent(labelPontuacao)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
														438, Short.MAX_VALUE)
												.addComponent(labelCartasViradas)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
												.addComponent(labelQuantDeCartasViradas2).addGap(64, 64, 64)))));

		layout.setVerticalGroup( /*
									 * Define o Group que posiciona e dimensiona componentes ao longo do eixo
									 * vertical.
									 */
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING) /*
																						 * Cria e retorna um
																						 * ParallelGroup com um
																						 * alinhamento de
																						 * Alignment.LEADING
																						 */
						.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup() /*
																												 * cria
																												 * um
																												 * grupo
																												 * sequencia
																												 */
								.addContainerGap()
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(labelPontos).addComponent(labelPontuacao)
										.addComponent(labelCartasViradas).addComponent(labelQuantDeCartasViradas2))
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34,
										Short.MAX_VALUE)
								.addComponent(painelPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 559,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addContainerGap()));

		pack();
	}

	private void SubMenuDeJogo_NovoJogoActionPerformed(java.awt.event.ActionEvent evt) {

		Game newJogo = new Game();
		newJogo.setVisible(true);
		Game.super.setVisible(false);// Torna o JFrame JogoNivelFacil com visibilidade false
	}

	private void SubMenuDeJogo_SairActionPerformed(java.awt.event.ActionEvent evt) throws Exception {
		System.exit(0);
	}
}
