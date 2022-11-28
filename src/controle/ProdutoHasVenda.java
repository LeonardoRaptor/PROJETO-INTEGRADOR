package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import modelo.Cliente;
import modelo.Livro;
import modelo.ProVenda;

public class ProdutoHasVenda {
	Connection conexao;
	private Statement st;
	private ArrayList<ProVenda> listaProV = new ArrayList<>();

	public ProVenda getProVendaPorId(int idVenda) {

		ProVenda pv = null;
		try {
			Statement st;
			conexao = Conexao.ligar();
			st = conexao.createStatement();
			ResultSet rs = st.executeQuery("select * from Produtos_has_Venda where idVenda = " + idVenda);
			while (rs.next()) {
				pv = new ProVenda();
				pv.setIdProduto(rs.getInt("Produtos_idProdutos"));
				pv.setIdVenda(rs.getInt("Venda_idVenda"));
			}
		} catch (SQLException a) {
			System.out.println(a.getMessage());
			System.out.println("Erro ao conectar � base de dados.");

		}

		return pv;

	}

	public ArrayList<ProVenda> listarTodos() {

		try {
			conexao = Conexao.ligar();
			System.out.println("Conectado � base de dados com sucesso.");

			st = conexao.createStatement();
			ResultSet rs2 = st.executeQuery("select * from Produtos_has_Venda order by idVenda");

			while (rs2.next()) {
				ProVenda pv = new ProVenda();
				pv.setIdProduto(rs2.getInt("Produtos_idProdutos"));
				pv.setIdVenda(rs2.getInt("Venda_idVenda"));
				listaProV.add(pv);
			}

			Conexao.desligar();

		} catch (SQLException a) {
			System.out.println(a.getMessage());
			System.out.println("Erro ao conectar � base de dados.");

		}

		return listaProV;
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

	public int cadastroProVenda(ProVenda pv) {

		int idCadastradoProVen = 0;
		try {

			Statement st;
			conexao = Conexao.ligar();
			st = conexao.createStatement();

			System.out.println("Conectado � base de dados com sucesso.");
			idCadastradoProVen = st
					.executeUpdate("Insert into Produtos_has_Venda (Produtos_idProdutos,Venda_idVenda) values " + "('"
							+ pv.getIdProduto() + "', '" + pv.getIdVenda() + "')");

			if (idCadastradoProVen == 0) {
				throw new SQLException("Creating book failed, no rows affected.");
			}

			Conexao.desligar();

		} catch (SQLException a) {
			System.out.println(a.getMessage());
			System.out.println("Erro ao conectar � base de dados.");
		}

		return idCadastradoProVen;
	}

}
