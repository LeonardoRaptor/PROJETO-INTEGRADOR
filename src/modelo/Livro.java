package modelo;

import java.sql.*;

public class Livro {
	private int qtde, idLi;
	private String preco;
	private String nomeLi, genero, autor;
	private int fornecedor;

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

	public String getPreco() {
		return preco;
	}

	public void setPreco(String preco2) {
		this.preco = preco2;
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

	public int getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(int fornecedor) {
		this.fornecedor = fornecedor;
	}

}
