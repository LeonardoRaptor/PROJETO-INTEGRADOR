package controle;
//import java.util.ArrayList;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import modelo.Funcionario;
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
					+ "('" + f.getNomeFunc() + "', '" + f.getEmailFunc() + "','\" + f.getTelefone() + \"', '" + f.getCpfFunc() + "', "
							+ "'" + f.getSenhaFunc()+ "')");
			
			Conexao.desligar();
			
		} catch (SQLException a) {
			System.out.println(a.getMessage());
				System.out.println("Erro ao conectar � base de dados.");
		}
	}
	public Funcionario logarConta(String login, String senha) {
		
		Funcionario funcionario = null;
		try {
			conexao = Conexao.ligar();
			System.out.println("Conectado � base de dados com sucesso.");
			
			st = conexao.createStatement();
			ResultSet rs1 = st.executeQuery("select * from funcionarios where nomeFuncionario='" + senha + "'");
			ResultSet rs2 = st.executeQuery("select * from funcionarios where nomeFuncionario='" + login + "'");

			if (rs1!=null && rs2!=null) {
				funcionario = new Funcionario();
				funcionario.setSenhaFunc(senha);
				funcionario.setNomeFunc(login);
			}
			
			
			Conexao.desligar();
			
		}catch(SQLException a) {
			System.out.println(a.getMessage());
			System.out.println("Erro ao conectar � base de dados.");
			
		}
		
		return funcionario;
	}
	public void acessarBd(){
		try {
			conexao = Conexao.ligar();
			System.out.println("Conectado � base de dados com sucesso.");
			
			st = conexao.createStatement();
			
			
			Conexao.desligar();
			
		}catch(SQLException a) {
			System.out.println(a.getMessage());
			System.out.println("Erro ao conectar � base de dados.");
			
		}
	}
	public static void alterarFuncionario(int posicao, Funcionario funcionarioSelecionado) {
		// TODO Auto-generated method stub
		
	}
}
