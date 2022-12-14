package modelo;

import java.sql.Date;
import java.util.ArrayList;

public class Venda {

	private int idVenda, qtdeVenda, funId, cliId;
	private String formaPagamento;
	private double valor;
	private String data;
	private ArrayList<Livro> produto;

	public int getIdVenda() {
		return idVenda;
	}

	public void setIdVenda(int idVenda) {
		this.idVenda = idVenda;
	}

	public int getQtdeVenda() {
		return qtdeVenda;
	}

	public void setQtdeVenda(int qtdeVenda) {
		this.qtdeVenda = qtdeVenda;
	}

	public int getFunId() {
		return funId;
	}

	public void setFunId(int funId) {
		this.funId = funId;
	}

	public int getCliId() {
		return cliId;
	}

	public void setCliId(int cliId) {
		this.cliId = cliId;
	}

	public String getFormaPagamento() {
		return formaPagamento;
	}

	public void setFormaPagamento(String formaPagamento) {
		this.formaPagamento = formaPagamento;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public String getData() {
		return data;
	}

	public void setData(String string) {
		this.data = string;
	}

	public ArrayList<Livro> getProduto() {
		return produto;
	}

	public void setProduto(ArrayList<Livro> produto) {
		this.produto = produto;
	}

}
