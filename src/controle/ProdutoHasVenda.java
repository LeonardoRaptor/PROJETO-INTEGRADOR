package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import modelo.Livro;
import modelo.ProVenda;

public class ProdutoHasVenda {
	Connection conexao;
	private Statement st;
	private ArrayList<ProVenda> listaProV = new ArrayList<>();
	private BDLivro bdl = new BDLivro();
	private Livro l = new Livro();

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
				pv.setQuantiVenda(rs.getInt("QuantVenda"));
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
			ResultSet rs2 = st.executeQuery("select * from Produtos_has_Venda order by Venda_idVenda");

			while (rs2.next()) {
				ProVenda pv = new ProVenda();
				pv.setIdProduto(rs2.getInt("Produtos_idProdutos"));
				pv.setIdVenda(rs2.getInt("Venda_idVenda"));
				pv.setQuantiVenda(rs2.getInt("QuantVenda"));
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

	public void cadastroProVenda(ProVenda pv) {

		try {

			PreparedStatement st;
			conexao = Conexao.ligar();

			String comandSql = "Insert into Produtos_has_Venda (Produtos_idProdutos,Venda_idVenda, QuantVenda) values (?, ?, ?)";

			st = conexao.prepareStatement(comandSql);

			st.setInt(1, pv.getIdProduto());
			st.setInt(2, pv.getIdVenda());
			st.setInt(3, pv.getQuantiVenda());

			st.executeUpdate();

			l = bdl.getLivroPorId(pv.getIdProduto());
			
			l.setQtde(l.getQtde()-pv.getQuantiVenda());
			
			
			bdl.removeQtdeLivro(l);

			System.out.println("Conectado � base de dados com sucesso.");

			Conexao.desligar();

		} catch (SQLException a) {
			System.out.println(a.getMessage());
			System.out.println("Erro ao conectar � base de dados.");
		}

	}

	public ArrayList<ProVenda> listarPorIDVenda(int idDaquelaVenda) {
		try {
			conexao = Conexao.ligar();
			System.out.println("Conectado � base de dados com sucesso.");

			st = conexao.createStatement();
			ResultSet rs2 = st.executeQuery("select * from Produtos_has_Venda where Venda_idVenda = " + idDaquelaVenda
					+ " order by Venda_idVenda");

			while (rs2.next()) {
				ProVenda pv = new ProVenda();
				pv.setIdProduto(rs2.getInt("Produtos_idProdutos"));
				pv.setIdVenda(rs2.getInt("Venda_idVenda"));
				pv.setQuantiVenda(rs2.getInt("QuantVenda"));
				listaProV.add(pv);
			}

			Conexao.desligar();

		} catch (SQLException a) {
			System.out.println(a.getMessage());
			System.out.println("Erro ao conectar � base de dados.");

		}

		return listaProV;
	}

}
