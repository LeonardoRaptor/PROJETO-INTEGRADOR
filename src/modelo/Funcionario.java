package modelo;
import java.sql.*;
public class Funcionario {
	private String emailFunc, nomeFunc, cpfFunc, senhaFunc;
	private int idFunc;
	public String getEmailFunc() {
		return emailFunc;
	}
	public void setEmailFunc(String emailFunc) {
		this.emailFunc = emailFunc;
	}
	public String getNomeFunc() {
		return nomeFunc;
	}
	public void setNomeFunc(String nomeFunc) {
		this.nomeFunc = nomeFunc;
	}
	public String getCpfFunc() {
		return cpfFunc;
	}
	public void setCpfFunc(String cpfFunc) {
		this.cpfFunc = cpfFunc;
	}
	public String getSenhaFunc() {
		return senhaFunc;
	}
	public void setSenhaFunc(String senhaFunc) {
		this.senhaFunc = senhaFunc;
	}
	public int getIdFunc() {
		return idFunc;
	}
	public void setIdFunc(int idFunc) {
		this.idFunc = idFunc;
	}
	
	
}
