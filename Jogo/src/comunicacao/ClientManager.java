package comunicacao;

import java.net.Socket;

public class ClientManager extends Thread {

	private Socket cliente;

	public ClientManager(Socket cliente) {
		this.cliente = cliente;
		start();
	}

}
