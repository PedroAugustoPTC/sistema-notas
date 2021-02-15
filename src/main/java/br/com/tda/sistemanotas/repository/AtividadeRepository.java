package br.com.tda.sistemanotas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.tda.sistemanotas.model.Atividade;
import br.com.tda.sistemanotas.model.Turma;

public interface AtividadeRepository extends JpaRepository<Atividade, Long> {

	public Atividade findByDescricao(String descricao);

	public List<Atividade> findByTurma(Turma turma);
}
