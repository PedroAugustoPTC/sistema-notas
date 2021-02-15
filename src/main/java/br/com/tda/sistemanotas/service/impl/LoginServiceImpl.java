package br.com.tda.sistemanotas.service.impl;

import java.io.UnsupportedEncodingException;
import java.security.InvalidParameterException;
import java.security.NoSuchAlgorithmException;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tda.sistemanotas.model.Aluno;
import br.com.tda.sistemanotas.security.Login;
import br.com.tda.sistemanotas.service.LoginService;
import br.com.tda.sistemanotas.util.CriptografarSenha;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	CriptografarSenha criptografia;

	@Autowired
	AlunoServiceImpl alunoService;

	@Override
	public Long logar(Login login) throws UnsupportedEncodingException, NoSuchAlgorithmException {
		String senhaCodificada = criptografia.criptografaSenha(login.getSenha());
		Aluno aluno = alunoService.listarPorCpf(login.getCpf());
		if (aluno == null) {
			throw new EntityNotFoundException("Este usuario não foi encontrado");
		} else if (aluno.getSenha().equals(senhaCodificada)) {
			return aluno.getId();
		} else {
			throw new InvalidParameterException("Senha inválida");
		}
	}

}
