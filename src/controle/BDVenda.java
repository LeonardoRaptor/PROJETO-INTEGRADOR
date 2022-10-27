package controle;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import modelo.Venda;

public class BDVenda {
	Connection conexao;
	private Statement st;
	private ArrayList<Venda> listaVenda = new ArrayList<>();

	public Venda getVendaPorId(int idVenda) {

		Venda v = null;
		try {
			Statement st;
			conexao = Conexao.ligar();
			st = conexao.createStatement();
			ResultSet rs = st.executeQuery("select * from Venda where idVenda = " + idVenda);
			while (rs.next()) {
				v = new Venda();
				v.setIdVenda(rs.getInt("idVenda"));
				v.setFunId(rs.getInt("Funcionarios_idFuncionario"));
				v.setCliId(rs.getInt("Clientes_idCLiente"));
				v.setValor(rs.getDouble("valorVenda"));
				v.setData(rs.getDate("dataVenda"));
				v.setFormaPagamento(rs.getString("formaPagamento"));
			}
		} catch (SQLException a) {
			System.out.println(a.getMessage());
			System.out.println("Erro ao conectar � base de dados.");

		}

		return v;

	}

	public void adquirirVenda(Venda v) {
		try {
			ResultSet rs = st.executeQuery("select * from Venda");
			while (rs.next()) {
				v.setId(rs.getInt("idFuncionario"));
				v.setCpfFunc(rs.getString("cpf"));
				v.setEmailFunc(rs.getString("emailFunc"));
				v.setNomeFunc(rs.getString("nomeFuncionario"));
				v.setSenhaFunc(rs.getString("senhaFunc"));
				v.setTelefone(rs.getString("telefone"));
			}
		} catch (SQLException a) {
			System.out.println(a.getMessage());
			System.out.println("Erro ao conectar � base de dados.");

		}

	}

	public int cadastro(Venda v) {

		int idCadastradoVenda = 0;
		try {

			Statement st;
			conexao = Conexao.ligar();
			st = conexao.createStatement();

			System.out.println("Conectado � base de dados com sucesso.");
			idCadastradoVenda = st.executeUpdate(
					"Insert into Venda (NomeFuncionario,EmailFunc, telefone, CPF, SenhaFunc) values " + "('"
							+ v.getNomeFunc() + "', '" + v.getEmailFunc() + "','" + v.getTelefone() + "', '"
							+ v.getCpfFunc() + "', " + "'" + v.getSenhaFunc() + "')");

			if (idCadastradoVenda == 0) {
				throw new SQLException("Creating Venda failed, no rows affected.");
			}

			Conexao.desligar();

		} catch (SQLException a) {
			System.out.println(a.getMessage());
			System.out.println("Erro ao conectar � base de dados.");
		}

		return idCadastradoVenda;
	}

	public ArrayList<Venda> listarTodos() {

		try {
			conexao = Conexao.ligar();
			System.out.println("Conectado � base de dados com sucesso.");

			st = conexao.createStatement();
			ResultSet rs1 = st.executeQuery("select * from Venda order by idVenda");

			while (rs1.next()) {
				Venda v = new Venda();
				v.setIdVenda(rs1.getInt("idVenda"));
				v.setCpfFunc(rs1.getString("cpf"));
				v.setEmailFunc(rs1.getString("emailFunc"));
				v.setNomeFunc(rs1.getString("nomeFuncionario"));
				v.setSenhaFunc(rs1.getString("senhaFunc"));
				v.setTelefone(rs1.getString("telefone"));
				listaVenda.add(v);
			}

			Conexao.desligar();

		} catch (SQLException a) {
			System.out.println(a.getMessage());
			System.out.println("Erro ao conectar � base de dados.");

		}

		return listaVenda;
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

	public boolean alterarVenda(Venda v) {
		boolean sucesso = true;
		try {

			conexao = Conexao.ligar();
			System.out.println("Conectado � base de dados com sucesso.");
			st = conexao.createStatement();
			sucesso = st.execute("update Venda set nomeFuncionario= '" + v.getNomeFunc() + "', emailFunc='"
					+ v.getEmailFunc() + "', cpf='" + v.getCpfFunc() + "', senhaFunc='" + v.getSenhaFunc()
					+ "', telefone='" + v.getTelefone() + "' where idVenda=" + v.getIdVenda());
			Conexao.desligar();
		} catch (SQLException a) {
			System.out.println(a.getMessage());
		}

		return sucesso;
	}

	public boolean removeAq(int idVenda) {
		boolean sucesso = true;
		try {

			conexao = Conexao.ligar();
			System.out.println("Conectado � base de dados com sucesso.");
			st = conexao.createStatement();
			sucesso = st.execute("delete from Venda where idVenda=" + idVenda);
			Conexao.desligar();
		} catch (SQLException a) {
			System.out.println(a.getMessage());
		}

		return sucesso;
	}
}
