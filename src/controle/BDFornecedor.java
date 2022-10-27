package controle;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import modelo.Fornecedor;

public class BDFornecedor {
	Connection conexao;
	private Statement st;
	private ArrayList<Fornecedor> listaFornecedor = new ArrayList<>();

	public Fornecedor getFornecedorPorId(int idFornecedor) {

		Fornecedor forn = null;
		try {
			Statement st;
			conexao = Conexao.ligar();
			st = conexao.createStatement();
			ResultSet rs = st.executeQuery("select * from Fornecedor where idFornecedor = " + idFornecedor);
			while (rs.next()) {
				forn = new Fornecedor();
				forn.setIdFor(rs.getInt("idFornecedor"));
				forn.setEmailFor(rs.getString("emailFornecedor"));
				forn.setNomeFor(rs.getString("nomeFornecedor"));
				forn.setTelefoneFor(rs.getString("telefoneFornecedor"));
			}
		} catch (SQLException a) {
			System.out.println(a.getMessage());
			System.out.println("Erro ao conectar � base de dados.");

		}

		return forn;

	}

	public void adquirirForn(Fornecedor forno) {
		try {
			ResultSet rs = st.executeQuery("select * from Fornecedor");
			while (rs.next()) {
				forno.setIdFor(rs.getInt("idFornecedor"));
				forno.setEmailFor(rs.getString("emailFornecedor"));
				forno.setNomeFor(rs.getString("nomeFornecedor"));
				forno.setTelefoneFor(rs.getString("telefoneFornecedor"));
			}
		} catch (SQLException a) {
			System.out.println(a.getMessage());
			System.out.println("Erro ao conectar � base de dados.");

		}

	}

	public int cadastroFor(Fornecedor forno) {

		int idCadastradoFornecedor = 0;
		try {

			Statement st;
			conexao = Conexao.ligar();
			st = conexao.createStatement();

			System.out.println("Conectado � base de dados com sucesso.");
			idCadastradoFornecedor = st.executeUpdate(
					"Insert into Fornecedor (NomeFornecedor, telefoneFornecedor, emailFornecedor) values " + "('"
							+ forno.getNomeFor() + "', '" + forno.getTelefoneFor() + "', '"
							+ forno.getEmailFor() + "')");

			if (idCadastradoFornecedor == 0) {
				throw new SQLException("Creating Fornecedor failed, no rows affected.");
			}

			Conexao.desligar();

		} catch (SQLException a) {
			System.out.println(a.getMessage());
			System.out.println("Erro ao conectar � base de dados.");
		}

		return idCadastradoFornecedor;
	}

	public ArrayList<Fornecedor> listarTodos() {

		try {
			conexao = Conexao.ligar();
			System.out.println("Conectado � base de dados com sucesso.");

			st = conexao.createStatement();
			ResultSet rs1 = st.executeQuery("select * from Fornecedor order by NomeFornecedor");

			while (rs1.next()) {
				Fornecedor forn = new Fornecedor();
				forn.setIdFor(rs1.getInt("idFornecedor"));
				forn.setEmailFor(rs1.getString("emailFornecedor"));
				forn.setNomeFor(rs1.getString("nomeFornecedor"));
				forn.setTelefoneFor(rs1.getString("telefoneFornecedor"));
				listaFornecedor.add(forn);
			}

			Conexao.desligar();

		} catch (SQLException a) {
			System.out.println(a.getMessage());
			System.out.println("Erro ao conectar � base de dados.");

		}

		return listaFornecedor;
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

	public boolean alterarFornecedor(Fornecedor forn) {
		boolean sucesso = true;
		try {

			conexao = Conexao.ligar();
			System.out.println("Conectado � base de dados com sucesso.");
			st = conexao.createStatement();
			sucesso = st.execute("update Fornecedor set nomeFornecedor= '" + forn.getNomeFor() + "', emailFornecedor='"
					+ forn.getEmailFor() + "', telefoneFornecedor='" + forn.getTelefoneFor()
					+ "' where idFornecedor=" + forn.getIdFor());
			Conexao.desligar();
		} catch (SQLException a) {
			System.out.println(a.getMessage());
		}

		return sucesso;
	}

	public boolean removeAq(int idFornecedor) {
		boolean sucesso = true;
		try {

			conexao = Conexao.ligar();
			System.out.println("Conectado � base de dados com sucesso.");
			st = conexao.createStatement();
			sucesso = st.execute("delete from Fornecedor where idFornecedor=" + idFornecedor);
			Conexao.desligar();
		} catch (SQLException a) {
			System.out.println(a.getMessage());
		}

		return sucesso;
	}
}
