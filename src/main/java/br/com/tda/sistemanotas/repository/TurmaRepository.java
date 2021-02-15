package br.com.tda.sistemanotas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.tda.sistemanotas.model.Aluno;
import br.com.tda.sistemanotas.model.Turma;

public interface TurmaRepository extends JpaRepository<Turma, Long> {

	public Turma findByNome(String turma);

	public boolean existsByNome(String nome);

	public List<Turma> findByAlunos(Aluno aluno);
}
