package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import modelo.Cliente;

public class BDCliente {
	Connection conexao;
	private Statement st;
	private ArrayList<Cliente> listaCli = new ArrayList<>();

	public Cliente getClientePorId(int idCli) {

		Cliente cli = null;
		try {
			Statement st;
			conexao = Conexao.ligar();
			st = conexao.createStatement();
			ResultSet rs = st.executeQuery("select * from clientes where idCliente = " + idCli);
			while (rs.next()) {
				cli = new Cliente();
				cli.setIdCli(rs.getInt("idCliente"));
				cli.setCpfCli(rs.getString("cpfCliente"));
				cli.setEmailCli(rs.getString("emailCliente"));
				cli.setNomeCli(rs.getString("nomeClientel"));
				cli.setTelefone(rs.getString("telefoneCliente"));
			}
		} catch (SQLException a) {
			System.out.println(a.getMessage());
			System.out.println("Erro ao conectar � base de dados.");

		}

		return cli;

	}

	public void adquirirCli(Cliente c) {
		try {
			ResultSet rs = st.executeQuery("select * from clientes");
			while (rs.next()) {
				c.setIdCli(rs.getInt("idCliente"));
				c.setCpfCli(rs.getString("cpfCliente"));
				c.setEmailCli(rs.getString("emailCliente"));
				c.setNomeCli(rs.getString("nomeClientel"));
				c.setTelefone(rs.getString("telefoneClietne"));
			}
		} catch (SQLException a) {
			System.out.println(a.getMessage());
			System.out.println("Erro ao conectar � base de dados.");

		}

	}

	public int cadastroCli(Cliente c) {

		int idCadastradoCli = 0;
		try {

			Statement st;
			conexao = Conexao.ligar();
			st = conexao.createStatement();

			System.out.println("Conectado � base de dados com sucesso.");
			idCadastradoCli = st.executeUpdate(
					"Insert into clientes (NomeClientel,CPFCliente, telefoneCliente, emailCliente) values " + "('"
							+ c.getNomeCli() + "', '" + c.getCpfCli() + "','" + c.getTelefone() + "', '"
							+ c.getEmailCli() + "')");

			if (idCadastradoCli == 0) {
				throw new SQLException("Creating Cliente failed, no rows affected.");
			}

			Conexao.desligar();

		} catch (SQLException a) {
			System.out.println(a.getMessage());
			System.out.println("Erro ao conectar � base de dados.");
		}

		return idCadastradoCli;
	}

	public ArrayList<Cliente> listarTodos() {

		try {
			conexao = Conexao.ligar();
			System.out.println("Conectado � base de dados com sucesso.");

			st = conexao.createStatement();
			ResultSet rs1 = st.executeQuery("select * from clientes order by NomeClientel");

			while (rs1.next()) {
				Cliente c = new Cliente();
				c.setIdCli(rs1.getInt("idCliente"));
				c.setCpfCli(rs1.getString("cpfCliente"));
				c.setEmailCli(rs1.getString("emailCliente"));
				c.setNomeCli(rs1.getString("nomeClientel"));
				c.setTelefone(rs1.getString("telefoneCliente"));
				listaCli.add(c);
			}

			Conexao.desligar();

		} catch (SQLException a) {
			System.out.println(a.getMessage());
			System.out.println("Erro ao conectar � base de dados.");

		}

		return listaCli;
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

	public boolean alterarCliente(Cliente c) {
		boolean sucesso = true;
		try {

			conexao = Conexao.ligar();
			System.out.println("Conectado � base de dados com sucesso.");
			st = conexao.createStatement();
			sucesso = st.execute("update Clientes set nomeClientel= '" + c.getNomeCli() + "', emailCliente='"
					+ c.getEmailCli() + "', cpfCliente='" + c.getCpfCli() + "', telefoneCliente='" + c.getTelefone()
					+ "' where idCliente=" + c.getIdCli());
			Conexao.desligar();
		} catch (SQLException a) {
			System.out.println(a.getMessage());
		}

		return sucesso;
	}

	public boolean removeAq(int idCliente) {
		boolean sucesso = true;
		try {

			conexao = Conexao.ligar();
			System.out.println("Conectado � base de dados com sucesso.");
			st = conexao.createStatement();
			sucesso = st.execute("delete from Clientes where idCliente=" + idCliente);
			Conexao.desligar();
		} catch (SQLException a) {
			System.out.println(a.getMessage());
		}

		return sucesso;
	}
}
