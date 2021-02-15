package br.com.tda.sistemanotas.service;

import java.util.List;

import br.com.tda.sistemanotas.model.Aluno;
import br.com.tda.sistemanotas.model.Nota;
import br.com.tda.sistemanotas.model.Turma;
import br.com.tda.sistemanotas.model.dto.NotaRequest;
import br.com.tda.sistemanotas.model.dto.Porcentagem;

public interface NotaService {
	public String salvar(List<NotaRequest> notas);

	public String atualizar(Nota nota);

	public List<Nota> listarTodos();

	public String deletar(Long id);

	public List<Porcentagem> porcentagemNota(Long id);

	public Double calculaPorcentagem(Turma turma, Aluno aluno);

	Object listarPorId(Long id);
}
