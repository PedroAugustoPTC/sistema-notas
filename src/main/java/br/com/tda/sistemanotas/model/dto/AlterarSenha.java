package br.com.tda.sistemanotas.model.dto;

public class AlterarSenha {

	String novaSenha;
	Long id;

	public AlterarSenha() {
		super();
	}

	public AlterarSenha(String novaSenha, Long id) {
		super();
		this.novaSenha = novaSenha;
		this.id = id;
	}

	/**
	 * @return the novaSenha
	 */
	public String getNovaSenha() {
		return novaSenha;
	}

	/**
	 * @param novaSenha the novaSenha to set
	 */
	public void setNovaSenha(String novaSenha) {
		this.novaSenha = novaSenha;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((novaSenha == null) ? 0 : novaSenha.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AlterarSenha other = (AlterarSenha) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (novaSenha == null) {
			if (other.novaSenha != null)
				return false;
		} else if (!novaSenha.equals(other.novaSenha))
			return false;
		return true;
	}

}
