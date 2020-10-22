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
	public static String nomeCliente;

	public static Jogador jogador;
	public static PlayerDAO jogadorDAO;

	public Client(String nomeJogador) {
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

		new Thread() {
			@Override
			public void run() {
				Game jogo = new Game(); 

				JOptionPane.showMessageDialog(null, nomeCliente + ", voce esta conectado. Bom Jogo !");
				jogo.setVisible(true); 
			}
		}.start();

	}
}