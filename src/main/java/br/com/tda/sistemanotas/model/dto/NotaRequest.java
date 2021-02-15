package br.com.tda.sistemanotas.model.dto;

import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class NotaRequest {

	@NotBlank(message = "A atividade nao pode ser nula")
	@OneToOne
	private String descricao;

	@NotBlank(message = "O aluno nao pode ser nulo")
	@OneToOne
	private String cpf;

	@NotNull(message = "Valor nao pode ser nulo")
	private Double valor;

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
	 * @return the cpf
	 */
	public String getCpf() {
		return cpf;
	}

	/**
	 * @param cpf the cpf to set
	 */
	public void setCpf(String cpf) {
		this.cpf = cpf;
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

}
