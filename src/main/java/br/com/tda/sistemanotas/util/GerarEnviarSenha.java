package br.com.tda.sistemanotas.util;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.text.RandomStringGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class GerarEnviarSenha {
	@Autowired
	CriptografarSenha criptografa;

	@Autowired
	public JavaMailSender emailSender;

	public String gerarEviarSenha(String email, String nomeAluno)
			throws UnsupportedEncodingException, NoSuchAlgorithmException {
		RandomStringGenerator pwdGenerator = new RandomStringGenerator.Builder().withinRange(48, 90).build();
		String senha = pwdGenerator.generate(10);
		System.out.println(sendMail(senha, email, nomeAluno));
		return criptografa.criptografaSenha(senha);
	}

	public String sendMail(String senha, String emailDestinatario, String nomeAluno) {
		try {
			SimpleMailMessage email = new SimpleMailMessage();

			email.setSubject("Nova senha");
			email.setText("Olá " + nomeAluno + ", sua nova senha é: " + senha + ". Utilize seu CPF juntamente com a senha para acesso ao aplicativo mobile.");
			email.setTo(emailDestinatario);
			emailSender.send(email);
			return "Email enviado";
		} catch (MailException e) {
			e.printStackTrace();
			return "Email não enviado";
		}
	}
}
