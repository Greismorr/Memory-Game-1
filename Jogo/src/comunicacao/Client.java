package comunicacao;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import javax.swing.JOptionPane;
import bancoDeDados.PlayerDAO;
import jogo.Jogador;
import jogo.Game;

public class Client {

	private static Client cliente;

	private String host;
	private int porta;
	public static String nomeCliente;

	public static Jogador jogador;
	public static PlayerDAO jogadorDAO;

	public Client(String host, int porta, String nomeJogador) {
		this.host = host;
		this.porta = porta;
		cliente = this;
		this.nomeCliente = nomeJogador;
		clienteJogador(nomeJogador);
	}
	
	public void clienteJogador(String nomeJogador) {

		try {
			
			jogadorDAO = new PlayerDAO();
			
			if (!jogadorDAO.procurarJogador(nomeJogador)) {
				
				jogador = new Jogador(nomeJogador, "0");
				jogadorDAO.inserir(jogador);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void executa() throws UnknownHostException, IOException {

		try {
			Socket cliente = new Socket(host, porta);

			new Thread() {
				@Override
				public void run() {
					Game jogo = new Game(); 

					JOptionPane.showMessageDialog(null, nomeCliente + ", você está conectado. Bom Jogo !");
					jogo.setVisible(true); 
				}
			}.start();

		} catch (UnknownHostException e) {
			JOptionPane.showMessageDialog(null, "Endereço Inválido. Tente novamente !");
			e.printStackTrace();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Servidor esta fora do ar");
			e.printStackTrace();
		}
	}

}