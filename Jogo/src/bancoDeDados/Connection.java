package bancoDeDados;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

public class Connection {
	
	public static void main(String[] args) throws Exception {
		System.setProperty("java.net.preferIPv4Stack" , "true");
		
		MongoClient connection = MongoClients.create(
			    "mongodb+srv://stackovercrow:redes12345@rankingmemory.ehqwu.mongodb.net/rankingMemory?retryWrites=true&w=majority");

		if (connection != null) {
			System.out.println("Conexão com banco de dados obtida com sucesso!");
			((MongoClient) connection).close();
		}

		connection.close();

	}

	public static MongoClient createConnectionToMyMongoDB() throws Exception {

		MongoClient mongoClient = MongoClients.create();
		return (MongoClient) mongoClient;

	}

}
