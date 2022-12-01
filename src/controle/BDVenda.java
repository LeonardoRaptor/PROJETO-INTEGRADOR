package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
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

			PreparedStatement st;
			conexao = Conexao.ligar();
			String comandoSQL = "Insert into Venda (QuantidadeVenda, valorVenda, formaPagamento, DataVenda, Funcionarios_idFuncionario, Clientes_idCliente) values (?,?,?,?,?,?)";
			st = conexao.prepareStatement(comandoSQL, Statement.RETURN_GENERATED_KEYS);

			st.setInt(1, v.getQtdeVenda());
			st.setDouble(2, v.getValor());
			st.setString(3, v.getFormaPagamento());
			st.setString(4, v.getData());
			st.setInt(5, v.getFunId());
			st.setInt(6, v.getCliId());

			System.out.println("Conectado � base de dados com sucesso.");
			idCadastradoVenda = st.executeUpdate();

			try (ResultSet generatedKeys = st.getGeneratedKeys()) {
				if (generatedKeys.next()) {
					v.setIdVenda(generatedKeys.getInt(1));
				} else {
					throw new SQLException("Creating Venda failed, no ID obtained.");
				}
			}

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
}
