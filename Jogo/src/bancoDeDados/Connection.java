package bancoDeDados;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

public class Connection {

	public static void main(String[] args) throws Exception {
		MongoClient mongoClient = (MongoClient) createConnectionToMyMongoDB();

		if (mongoClient != null) {
			System.out.println("Conexão com banco de dados obtida com sucesso!");
			((MongoClient) mongoClient).close();
		}

		mongoClient.close();

	}

	public static MongoClient createConnectionToMyMongoDB() throws Exception {

		MongoClient mongoClient = MongoClients.create();
		return (MongoClient) mongoClient;

	}

}
