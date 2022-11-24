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
				v.setData(rs.getString("dataVenda"));
				v.setFormaPagamento(rs.getString("formaPagamento"));
				v.setQtdeVenda(rs.getInt("QuantidadeVenda"));
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
				v.setIdVenda(rs.getInt("idVenda"));
				v.setFunId(rs.getInt("Funcionarios_idFuncionario"));
				v.setCliId(rs.getInt("Clientes_idCLiente"));
				v.setValor(rs.getDouble("valorVenda"));
				v.setData(rs.getString("dataVenda"));
				v.setFormaPagamento(rs.getString("formaPagamento"));
				v.setQtdeVenda(rs.getInt("QuantidadeVenda"));
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
					"Insert into Venda (QuantidadeVenda, valorVenda, formaPagamento, DataVenda, Funcionarios_idFuncionario, Clientes_idCliente) values "
							+ "('" + v.getQtdeVenda() + "', '" + v.getValor() + "','" + v.getFormaPagamento() + "', '"
							+ v.getData() + "', " + "'" + v.getFunId() + "', '" + v.getCliId() + "')");

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
				v.setFunId(rs1.getInt("Funcionarios_idFuncionario"));
				v.setCliId(rs1.getInt("Clientes_idCLiente"));
				v.setValor(rs1.getDouble("valorVenda"));
				v.setData(rs1.getString("dataVenda"));
				v.setFormaPagamento(rs1.getString("formaPagamento"));
				v.setQtdeVenda(rs1.getInt("QuantidadeVenda"));
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
