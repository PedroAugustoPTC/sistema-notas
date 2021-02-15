package br.com.tda.sistemanotas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.tda.sistemanotas.model.Aluno;
import br.com.tda.sistemanotas.model.Turma;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {
	public boolean existsByCpf(String cpf);

	public Aluno findByCpf(String cpf);

	public List<Aluno> findByTurmas(Turma turma);
}
