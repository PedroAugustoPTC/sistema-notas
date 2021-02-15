package br.com.tda.sistemanotas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.tda.sistemanotas.model.Aluno;
import br.com.tda.sistemanotas.model.Atividade;
import br.com.tda.sistemanotas.model.Nota;

public interface NotaRepository extends JpaRepository<Nota, Long> {

	public List<Nota> findByAluno(Aluno aluno);

	public List<Nota> findByAtividade(Atividade atividade);

	public List<Nota> findByAluno(Atividade atividade);

}
