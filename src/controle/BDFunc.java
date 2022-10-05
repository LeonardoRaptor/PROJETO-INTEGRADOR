package controle;

//import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import modelo.Funcionario;

//import modelo.Funcionario;
public class BDFunc {
	Connection conexao;
	private Statement st;
	private ArrayList<Funcionario> lista = new ArrayList<>();

	public void adquirirFunc(Funcionario f) {
		try {
			ResultSet rs = st.executeQuery("select * from funcionarios");
			while (rs.next()) {
				f.setId(rs.getInt("idFuncionario"));
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

	public int cadastro(Funcionario f) {

		int idCadastrado = 0;
		try {

			Statement st;
			conexao = Conexao.ligar();
			st = conexao.createStatement();

			System.out.println("Conectado � base de dados com sucesso.");
			idCadastrado = st.executeUpdate(
					"Insert into funcionarios (NomeFuncionario,EmailFunc, telefone, CPF, SenhaFunc) values " + "('"
							+ f.getNomeFunc() + "', '" + f.getEmailFunc() + "','" + f.getTelefone() + "', '"
							+ f.getCpfFunc() + "', " + "'" + f.getSenhaFunc() + "')");

			if (idCadastrado == 0) {
				throw new SQLException("Creating user failed, no rows affected.");
			}

			Conexao.desligar();

		} catch (SQLException a) {
			System.out.println(a.getMessage());
			System.out.println("Erro ao conectar � base de dados.");
		}

		return idCadastrado;
	}

	public ArrayList<Funcionario> listarTodos() {

		
		try {
			conexao = Conexao.ligar();
			System.out.println("Conectado � base de dados com sucesso.");

			st = conexao.createStatement();
			ResultSet rs1 = st.executeQuery("select * from funcionarios order by NomeFuncionario");

			while (rs1.next()) {
				Funcionario f = new Funcionario();
				f.setId(rs1.getInt("idFuncionario"));
				f.setCpfFunc(rs1.getString("cpf"));
				f.setEmailFunc(rs1.getString("emailFunc"));
				f.setNomeFunc(rs1.getString("nomeFuncionario"));
				f.setSenhaFunc(rs1.getString("senhaFunc"));
				f.setTelefone(rs1.getString("telefone"));
				lista.add(f);
			}

			Conexao.desligar();

		} catch (SQLException a) {
			System.out.println(a.getMessage());
			System.out.println("Erro ao conectar � base de dados.");

		}

		return lista;
	}

	public Funcionario logarConta(String login, String senha) {

		Funcionario funcionario = null;
		try {
			conexao = Conexao.ligar();
			System.out.println("Conectado � base de dados com sucesso.");

			st = conexao.createStatement();
			ResultSet rs1 = st.executeQuery(
					"select * from funcionarios where senhaFunc='" + senha + "' and nomeFuncionario='" + login + "'");

			Funcionario f = new Funcionario();
			while (rs1.next()) {
				f.setId(rs1.getInt("idFuncionario"));
				f.setCpfFunc(rs1.getString("cpf"));
				f.setEmailFunc(rs1.getString("emailFunc"));
				f.setNomeFunc(rs1.getString("nomeFuncionario"));
				f.setSenhaFunc(rs1.getString("senhaFunc"));
				f.setTelefone(rs1.getString("telefone"));
			}

			Conexao.desligar();

		} catch (SQLException a) {
			System.out.println(a.getMessage());
			System.out.println("Erro ao conectar � base de dados.");

		}

		return funcionario;
	}

	public void acessarBd() {
		try {
			conexao = Conexao.ligar();
			System.out.println("Conectado � base de dados com sucesso.");

			st = conexao.createStatement();

			Conexao.desligar();

		} catch (SQLException a) {
			System.out.println(a.getMessage());
			System.out.println("Erro ao conectar � base de dados.");

		}
	}

	public void alterarFuncionario(int posicao, Funcionario funcionarioSelecionado) {

	}

	public ArrayList<Funcionario> removeAq() {
		try {
			conexao = Conexao.ligar();
			System.out.println("Conectado � base de dados com sucesso.");

			Funcionario f = new Funcionario();
			
			st = conexao.createStatement();
			PreparedStatement pat = ((Connection) st)
					.prepareStatement("delete from Funcionarios where idFuncionario=");
			
			pat.executeQuery();
			
			
			
			lista.remove(f);
			
			
			
			Conexao.desligar();

		} catch (SQLException a) {
			System.out.println(a.getMessage());
			System.out.println("Erro ao conectar � base de dados.");

		}
		return lista;
	}
}
