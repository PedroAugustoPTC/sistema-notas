package br.com.tda.sistemanotas.service;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import br.com.tda.sistemanotas.model.Aluno;
import br.com.tda.sistemanotas.model.dto.AlterarSenha;
import br.com.tda.sistemanotas.model.dto.AlunoRequest;
import br.com.tda.sistemanotas.model.dto.AlunoResponse;

public interface AlunoService {
	public AlunoResponse salvar(AlunoRequest aluno) throws UnsupportedEncodingException, NoSuchAlgorithmException;

	public String atualizar(AlunoRequest alunoRequest);

	public List<Aluno> listarTodos();

	public Aluno listarPorCpf(String cpf);

	public Aluno listarPorId(Long id);

	public String deletar(String cpf);

	public List<Aluno> listarPorIdTurma(Long id);

	public String alterarSenha(AlterarSenha senhaNova) throws UnsupportedEncodingException, NoSuchAlgorithmException;
}
