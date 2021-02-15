package br.com.tda.sistemanotas.model.dto;

import java.util.List;

import javax.validation.constraints.NotBlank;

import br.com.tda.sistemanotas.model.Pessoa;
import br.com.tda.sistemanotas.model.Turma;

public class AlunoRequest extends Pessoa {
	@NotBlank(message = "Matricula nao pode ser nulo")
	private String matricula;

	private List<Turma> listaTurma;

	public List<Turma> getListaTurma() {
		return listaTurma;
	}

	public void setListaTurma(List<Turma> listaTurma) {
		this.listaTurma = listaTurma;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

}
