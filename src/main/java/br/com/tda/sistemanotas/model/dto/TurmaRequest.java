package br.com.tda.sistemanotas.model.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.tda.sistemanotas.model.Professor;

public class TurmaRequest {

	@NotBlank(message = "O nome nao pode ser nulo")
	private String nome;

	@NotBlank(message = "O semestre nao pode ser nulo")
	private String semestre;

	@NotNull(message = "O ano nao pode ser nulo")
	private Integer ano;

	@NotNull(message = "O professor nao pode ser nulo")
	private Professor professor;

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSemestre() {
		return semestre;
	}

	public void setSemestre(String semestre) {
		this.semestre = semestre;
	}

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

}
