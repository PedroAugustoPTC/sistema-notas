package br.com.tda.sistemanotas.service;

import java.util.List;

import br.com.tda.sistemanotas.model.Atividade;
import br.com.tda.sistemanotas.model.Turma;
import br.com.tda.sistemanotas.model.dto.AtividadeDAO;

public interface AtividadeService {

	public Atividade salvar(AtividadeDAO atividade);

	public List<Atividade> listarTodos();

	public Atividade atualizar(Atividade atividade);

	public String deletar(Long id);

	public Atividade listarPorDescricao(String atividadeDescricao);

	public void verificaValorMaximo(Turma turma, Double valor);

	public List<Atividade> listarPorTurma(Turma turma);

	public Atividade listarPorId(Long id);
}
