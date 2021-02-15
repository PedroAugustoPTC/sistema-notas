package br.com.tda.sistemanotas.controller;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.tda.sistemanotas.security.Login;
import br.com.tda.sistemanotas.service.impl.LoginServiceImpl;

@RestController
@RequestMapping("login")
public class LoginController {

	@Autowired
	LoginServiceImpl loginService;

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Long> listar(@RequestBody Login login)
			throws UnsupportedEncodingException, NoSuchAlgorithmException {
		return ResponseEntity.status(HttpStatus.OK).body(loginService.logar(login));
	}
}
