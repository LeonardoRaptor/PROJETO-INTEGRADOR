package controle;
//import java.util.ArrayList;
import java.sql.*;

import visao.JanelaCadastrar;
import visao.JanelaLogin;

//import modelo.Funcionario;
public class BDFunc {
	Connection conexao;
	
	//ArrayList <Funcionario> func = new ArrayList <Funcionario> ();
	//public void addFunc(Funcionario f) {
	//	func.add(f);
		
	//}
	//public void delFunc(Funcionario f) {
	//	func.remove(f);
	//}
	public void cadastro () {
		try {
			
			Statement st;
			
			st = conexao.createStatement();
			conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "aluno");
			System.out.println("Conectado � base de dados com sucesso.");
			st.executeUpdate("Insert into funcionarios (NomeFuncionario,EmailFunc,CPF, SenhaFunc) values "
					+ "('" + JanelaCadastrar.nome + "', '" + JanelaCadastrar.email + "', '" + JanelaCadastrar.cpf + "', "
							+ "'" + JanelaCadastrar.senha + "')");
			
		} catch (SQLException a) {
			System.out.println(a.getMessage());
				System.out.println("Erro ao conectar � base de dados.");
		}
	}
	public void logarConta() {
		try {
			conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "aluno");
			System.out.println("Conectado � base de dados com sucesso.");
			
			Statement st = null;
			st.executeUpdate("select * from funcionarios where nomeFuncionario='" + JanelaLogin.login + "' and senhaFunc = '" + JanelaLogin.senha + "'");
			
			
		}catch(SQLException a) {
			System.out.println(a.getMessage());
			System.out.println("Erro ao conectar � base de dados.");
			
		}
	}
}
