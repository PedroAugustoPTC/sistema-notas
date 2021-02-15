package br.com.tda.sistemanotas.service;

import java.util.List;

import br.com.tda.sistemanotas.model.Professor;

public interface ProfessorService {

	public Professor salvar(Professor professor);

	public Professor atualizar(Professor professor);

	public List<Professor> listarTodos();

	public Professor listarPorCpf(String cpf);

	public String deletar(String cpf);

	public boolean verificaPorCpf(String cpf);

	Professor listarPorId(Long id);

}
