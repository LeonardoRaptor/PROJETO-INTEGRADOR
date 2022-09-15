package controle;
//import java.util.ArrayList;
import java.sql.*;

import modelo.Funcionario;
import visao.JanelaCadastrar;
import visao.JanelaLogin;
import visao.Menu;

//import modelo.Funcionario;
public class BDFunc {
	Connection conexao;
	private Statement st;
	Funcionario f = new Funcionario();
	
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
			conexao = Conexao.ligar();
			st = conexao.createStatement();
			
			System.out.println("Conectado � base de dados com sucesso.");
			st.executeUpdate("Insert into funcionarios (NomeFuncionario,EmailFunc,CPF, SenhaFunc) values "
					+ "('" + f.getNomeFunc() + "', '" + f.getEmailFunc() + "', '" + f.getCpfFunc() + "', "
							+ "'" + f.getSenhaFunc()+ "')");
			
			Conexao.desligar();
			
		} catch (SQLException a) {
			System.out.println(a.getMessage());
				System.out.println("Erro ao conectar � base de dados.");
		}
	}
	public void logarConta(String login, String senha) {
		try {
			conexao = Conexao.ligar();
			System.out.println("Conectado � base de dados com sucesso.");
			
			st = conexao.createStatement();
			st.execute("select * from funcionarios where nomeFuncionario='" + login + "' and senhaFunc = '" + senha + "'");
			if(st!=null) {
				JanelaLogin jl = new JanelaLogin();
				jl.setVisible(false);
				Menu m = new Menu();
				m.setVisible(true);
			}
			Conexao.desligar();
			
		}catch(SQLException a) {
			System.out.println(a.getMessage());
			System.out.println("Erro ao conectar � base de dados.");
			
		}
	}
}
