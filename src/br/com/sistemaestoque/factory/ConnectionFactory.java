package br.com.sistemaestoque.factory;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
	
	//Nome do usuário do mysql
	private static final String USERNAME = "root";
	
	//Senha do banco 
	private static final String PASSWORD = "";
	
	//Caminho do banco/porta/nome do banco
	private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/sistemaestoque";

	//Conexão com o banco
	public static Connection createConnectionToMySQL() throws Exception {
		//Faz a classe ser carregar pela JVM
		Class.forName("com.mysql.jdbc.Driver");
		//Cria a conexao com banco
		Connection connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
	
		return connection;
	}
	
	public static void main(String[] args) throws Exception{
		//recuperar uma conexao com o banco de dados
		Connection con = createConnectionToMySQL();
		//Testar se a conexao e nula
		if(con!= null) {
				System.out.println("conectado!");
				con.close();
		}
	}
	
}
