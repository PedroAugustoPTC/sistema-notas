package br.com.tda.sistemanotas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.tda.sistemanotas.model.Professor;

public interface ProfessorRepository extends JpaRepository<Professor, Long> {

	public boolean existsByCpf(String cpf);

	public Professor findByCpf(String cpf);
}
