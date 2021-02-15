package br.com.tda.sistemanotas.model.dto;

import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.tda.sistemanotas.model.Turma;

public class AtividadeDAO {
	@NotNull(message = "A data nao pode ser nula")
	private String data;

	@NotNull(message = "O valor nao pode ser nulo")
	private Double valor;

	@NotBlank(message = "A descrição não pode ficar nula")
	private String descricao;

	@NotNull(message = "Turma não pode ser nulo")
	@OneToOne
	private Turma turma;

	/**
	 * @return the data
	 */
	public String getData() {
		return data;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(String data) {
		this.data = data;
	}

	/**
	 * @return the valor
	 */
	public Double getValor() {
		return valor;
	}

	/**
	 * @param valor the valor to set
	 */
	public void setValor(Double valor) {
		this.valor = valor;
	}

	/**
	 * @return the descricao
	 */
	public String getDescricao() {
		return descricao;
	}

	/**
	 * @param descricao the descricao to set
	 */
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	/**
	 * @return the turma
	 */
	public Turma getTurma() {
		return turma;
	}

	/**
	 * @param turma the turma to set
	 */
	public void setTurma(Turma turma) {
		this.turma = turma;
	}

}
