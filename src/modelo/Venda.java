package modelo;
import java.util.Date;

public class Venda {
	
	private int idVenda, qtdeVenda, funId, cliId;
	private String formaPagamento;
	private double valor;
	private Date data;
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
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	
	
	
}
