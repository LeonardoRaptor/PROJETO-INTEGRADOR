import java.sql.*;
public class Livro {
	private int qtde, idLi;
	private double preco;
	private String nomeLi, genero, autor;
	public int getQtde() {
		return qtde;
	}
	public void setQtde(int qtde) {
		this.qtde = qtde;
	}
	public int getIdLi() {
		return idLi;
	}
	public void setIdLi(int idLi) {
		this.idLi = idLi;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	public String getNomeLi() {
		return nomeLi;
	}
	public void setNomeLi(String nomeLi) {
		this.nomeLi = nomeLi;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
}
