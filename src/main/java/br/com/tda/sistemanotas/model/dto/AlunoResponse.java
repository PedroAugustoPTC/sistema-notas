package br.com.tda.sistemanotas.model.dto;

public class AlunoResponse {

	private String nome;
	private String matricula;
	private String cpf;
	private String email;

	public AlunoResponse(String nome, String matricula, String cpf, String email) {
		super();
		this.nome = nome;
		this.matricula = matricula;
		this.cpf = cpf;
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

}
