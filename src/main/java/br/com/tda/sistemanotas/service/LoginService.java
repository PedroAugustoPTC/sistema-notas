package br.com.tda.sistemanotas.service;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import br.com.tda.sistemanotas.security.Login;

public interface LoginService {

	public Long logar(Login login) throws UnsupportedEncodingException, NoSuchAlgorithmException;
}
