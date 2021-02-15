package br.com.tda.sistemanotas.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.springframework.stereotype.Service;

@Service
public class CriptografarSenha {

	public String criptografaSenha(String senha) throws UnsupportedEncodingException, NoSuchAlgorithmException {

		MessageDigest algorithm = MessageDigest.getInstance("SHA-256");
		byte messageDigest[] = algorithm.digest(senha.getBytes("UTF-8"));

		StringBuilder hexString = new StringBuilder();

		for (byte b : messageDigest) {
			hexString.append(String.format("%02X", 0xFF & b));
		}
		String senhahex = hexString.toString();

		System.out.println(senhahex);
		return senhahex;
	}
}
