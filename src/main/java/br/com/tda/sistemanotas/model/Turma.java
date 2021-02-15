package br.com.tda.sistemanotas.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity(name = "tb_turma")
@PrimaryKeyJoinColumn(name = "id")
@JsonIgnoreProperties({ "alunos", "hibernateLazyInitializer", "handler" })
public class Turma {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "O nome nao pode ser nulo")
	private String nome;

	@NotBlank(message = "O semestre nao pode ser nulo")
	private String semestre;

	@NotNull(message = "O ano nao pode ser nulo")
	private Integer ano;

	@ManyToMany(mappedBy = "turmas", fetch = FetchType.LAZY)
	private List<Aluno> alunos;

	@NotNull(message = "O professor nao pode ser nulo")
	@ManyToOne
	private Professor professor;

	public Turma() {
		super();
	}

	public Turma(@NotBlank(message = "O nome nao pode ser nulo") String nome,
			@NotBlank(message = "O semestre nao pode ser nulo") String semestre,
			@NotBlank(message = "O ano nao pode ser nulo") Integer ano,
			@NotBlank(message = "O professor nao pode ser nulo") Professor professor) {
		super();
		this.nome = nome;
		this.semestre = semestre;
		this.ano = ano;
		this.professor = professor;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public List<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ano == null) ? 0 : ano.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((alunos == null) ? 0 : alunos.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((professor == null) ? 0 : professor.hashCode());
		result = prime * result + ((semestre == null) ? 0 : semestre.hashCode());
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
		Turma other = (Turma) obj;
		if (ano == null) {
			if (other.ano != null)
				return false;
		} else if (!ano.equals(other.ano))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (alunos == null) {
			if (other.alunos != null)
				return false;
		} else if (!alunos.equals(other.alunos))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (professor == null) {
			if (other.professor != null)
				return false;
		} else if (!professor.equals(other.professor))
			return false;
		if (semestre == null) {
			if (other.semestre != null)
				return false;
		} else if (!semestre.equals(other.semestre))
			return false;
		return true;
	}

}
