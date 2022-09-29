package controle;
//import java.util.ArrayList;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import modelo.Funcionario;
import visao.JanelaAdmin;
import visao.JanelaLogin;
import visao.Menu;

//import modelo.Funcionario;
public class BDFunc {
	Connection conexao;
	private Statement st;
	Funcionario f = new Funcionario();

	
	public void adquirirFunc() {
		try {
			ResultSet rs = st.executeQuery("select * from funcionarios");
			while (rs.next()) {
				f.setId(rs.getInt("id"));
				f.setCpfFunc(rs.getString("cpf"));
				f.setEmailFunc(rs.getString("emailFunc"));
				f.setNomeFunc(rs.getString("nomeFuncionario"));
				f.setSenhaFunc(rs.getString("senhaFunc"));
				f.setTelefone(rs.getString("telefone"));
			}
		} catch (SQLException a) {
			System.out.println(a.getMessage());
			System.out.println("Erro ao conectar � base de dados.");
			
		}
		
	}
	
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
			ResultSet rs1 = st.executeQuery("select * from funcionarios where senhaFunc='" + senha + "' and nomeFuncionario='" + login + "'");

			while (rs1.next()) {
				f.setCpfFunc(rs1.getString("cpf"));
				f.setEmailFunc(rs1.getString("emailFunc"));
				f.setNomeFunc(rs1.getString("nomeFuncionario"));
				f.setSenhaFunc(rs1.getString("senhaFunc"));
				f.setTelefone(rs1.getString("telefone"));
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
	public void alterarFuncionario(int posicao, Funcionario funcionarioSelecionado) {
		
		
		
		
	}
}
