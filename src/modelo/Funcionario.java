package modelo;

public class Funcionario {
	private String emailFunc, nomeFunc, cpfFunc, senhaFunc, telefone;
	private int id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
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
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getTelefone() {
		return telefone;
	}
	
}
