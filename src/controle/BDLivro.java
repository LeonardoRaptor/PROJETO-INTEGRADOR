package controle;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import modelo.Livro;

public class BDLivro {
	Connection conexao;
	private Statement st;
	private ArrayList<Livro> cadastro = new ArrayList<>();

	public Livro getLivroPorId(int idProdu) {

		Livro l = null;
		try {
			Statement st;
			conexao = Conexao.ligar();
			st = conexao.createStatement();
			ResultSet rs = st.executeQuery("select * from produtos where idProdutos = " + idProdu);
			while (rs.next()) {
				l = new Livro();
				l.setIdLi(rs.getInt("idProdutos"));
				l.setPreco(rs.getString("PreçoProduto"));
				l.setQtde(rs.getInt("qt_estoque"));
				l.setNomeLi(rs.getString("nome"));
				l.setGenero(rs.getString("genero"));
				l.setAutor(rs.getString("autor"));
				l.setFornecedor(rs.getInt("Fornecedor_idFornecedor"));
			}
		} catch (SQLException a) {
			System.out.println(a.getMessage());
			System.out.println("Erro ao conectar � base de dados.");

		}

		return l;

	}

	public void adquirirLi(Livro l) {
		try {
			ResultSet rs = st.executeQuery("select * from produtos");
			while (rs.next()) {
				l.setIdLi(rs.getInt("idProdutos"));
				l.setPreco(rs.getString("PreçoProduto"));
				l.setQtde(rs.getInt("qt_estoque"));
				l.setNomeLi(rs.getString("nome"));
				l.setGenero(rs.getString("genero"));
				l.setAutor(rs.getString("autor"));
				l.setFornecedor(rs.getInt("Fornecedor_idFornecedor"));
			}
		} catch (SQLException a) {
			System.out.println(a.getMessage());
			System.out.println("Erro ao conectar � base de dados.");

		}

	}

	public int cadastroLi(Livro l) {

		int idCadastradoLi = 0;
		try {

			Statement st;
			conexao = Conexao.ligar();
			st = conexao.createStatement();

			System.out.println("Conectado � base de dados com sucesso.");
			idCadastradoLi = st
					.executeUpdate("Insert into produtos (PreçoProduto,Nome, qt_estoque, Autor, Genero,Fornecedor_idFornecedor) values " + "('"
							+ l.getPreco() + "', '" + l.getNomeLi() + "','" + l.getQtde() + "', '" + l.getAutor()
							+ "', " + "'" + l.getGenero() + "','" + l.getFornecedor() + "')");

			if (idCadastradoLi == 0) {
				throw new SQLException("Creating book failed, no rows affected.");
			}

			Conexao.desligar();

		} catch (SQLException a) {
			System.out.println(a.getMessage());
			System.out.println("Erro ao conectar � base de dados.");
		}

		return idCadastradoLi;
	}

	public ArrayList<Livro> listarTodos() {

		try {
			conexao = Conexao.ligar();
			System.out.println("Conectado � base de dados com sucesso.");

			st = conexao.createStatement();
			ResultSet rs1 = st.executeQuery("select * from produtos order by Nome");

			while (rs1.next()) {
				Livro l = new Livro();
				l.setIdLi(rs1.getInt("idProdutos"));
				l.setPreco(rs1.getString("PreçoProduto"));
				l.setQtde(rs1.getInt("qt_estoque"));
				l.setNomeLi(rs1.getString("nome"));
				l.setGenero(rs1.getString("genero"));
				l.setAutor(rs1.getString("autor"));
				l.setFornecedor(rs1.getInt("Fornecedor_idFornecedor"));
				cadastro.add(l);
			}

			Conexao.desligar();

		} catch (SQLException a) {
			System.out.println(a.getMessage());
			System.out.println("Erro ao conectar � base de dados.");

		}

		return cadastro;
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

	public boolean alterarLivro(Livro l) {
		boolean sucesso = true;
		try {

			conexao = Conexao.ligar();
			System.out.println("Conectado � base de dados com sucesso.");
			st = conexao.createStatement();
			sucesso = st.execute("update produtos set nome = '" + l.getNomeLi() + "', PreçoProduto='"
					+ l.getPreco() + "', autor='" + l.getAutor() + "', genero='" + l.getGenero()
					+ "', qt_estoque='" + l.getQtde() + "', Fornecedor_idFornecedor='"+ l.getFornecedor() +"' where idProdutos=" + l.getIdLi());
			Conexao.desligar();
		} catch (SQLException a) {
			System.out.println(a.getMessage());
		}

		return sucesso;
	}

	public boolean removeAqui(int idProdutos) {
		boolean sucesso = true;
		try {

			conexao = Conexao.ligar();
			System.out.println("Conectado � base de dados com sucesso.");
			st = conexao.createStatement();
			sucesso = st.execute("delete from produtos where idProdutos=" + idProdutos);
			Conexao.desligar();
		} catch (SQLException a) {
			System.out.println(a.getMessage());
		}

		return sucesso;
	}
	
	public boolean removeQtdeLivro(Livro l) {
		boolean sucesso = true;
		try {

			conexao = Conexao.ligar();
			System.out.println("Conectado � base de dados com sucesso.");
			st = conexao.createStatement();
			sucesso = st.execute("update produtos set nome = '" + l.getNomeLi() + "', PreçoProduto='"
					+ l.getPreco() + "', autor='" + l.getAutor() + "', genero='" + l.getGenero()
					+ "', qt_estoque='" + l.getQtde() + "', Fornecedor_idFornecedor='"+ l.getFornecedor() +"' where idProdutos=" + l.getIdLi());
			Conexao.desligar();
		} catch (SQLException a) {
			System.out.println(a.getMessage());
		}

		return sucesso;
	}
}
