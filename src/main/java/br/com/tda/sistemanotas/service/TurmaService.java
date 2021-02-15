package br.com.tda.sistemanotas.service;

import java.util.List;
import java.util.Optional;

import br.com.tda.sistemanotas.model.Aluno;
import br.com.tda.sistemanotas.model.Turma;
import br.com.tda.sistemanotas.model.dto.TurmaRequest;

public interface TurmaService {
	public String salvar(TurmaRequest turma);

	public Turma atualizar(Turma turma);

	public List<Turma> listarTodos();

	public String deletar(Long id);

	public Turma listarPorNome(String nome);

	public boolean verificaPorId(Long id);

	public Optional<Turma> listaPorId(Long id);

	public List<Turma> listaPorAluno(Aluno aluno);

	Turma listarPorId(Long id);
}
