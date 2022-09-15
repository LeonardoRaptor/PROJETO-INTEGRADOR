package controle;
import java.sql.*;
public class Conexao {
	static Connection conexao;
	private Statement st;
	public static Connection ligar() {
		try {
			conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "aluno");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conexao;
	}
	public static void desligar() {
		try {
			conexao.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
