package br.com.tda.sistemanotas.controller;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.tda.sistemanotas.model.Aluno;
import br.com.tda.sistemanotas.model.dto.AlterarSenha;
import br.com.tda.sistemanotas.model.dto.AlunoRequest;
import br.com.tda.sistemanotas.model.dto.AlunoResponse;
import br.com.tda.sistemanotas.service.impl.AlunoServiceImpl;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("aluno")
public class AlunoController {
	@Autowired
	AlunoServiceImpl alunoService;

	@RequestMapping(value = "salvar", method = RequestMethod.POST)
	public ResponseEntity<AlunoResponse> salvar(@RequestBody @Valid AlunoRequest alunoRequest)
			throws UnsupportedEncodingException, NoSuchAlgorithmException {
		return ResponseEntity.status(HttpStatus.CREATED).body(alunoService.salvar(alunoRequest));
	}

	@RequestMapping(value = "listar", method = RequestMethod.GET)
	public ResponseEntity<List<Aluno>> listar() {
		return ResponseEntity.status(HttpStatus.OK).body(alunoService.listarTodos());
	}

	@RequestMapping(value = "listar/id={id}", method = RequestMethod.GET)
	public ResponseEntity<Aluno> listarPorId(@RequestBody @PathVariable Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(alunoService.listarPorId(id));
	}

	@RequestMapping(value = "listar/idTurma={idTurma}", method = RequestMethod.GET)
	public ResponseEntity<List<Aluno>> listarPorIdTurma(@RequestBody @PathVariable Long idTurma) {
		return ResponseEntity.status(HttpStatus.OK).body(alunoService.listarPorIdTurma(idTurma));
	}

	@RequestMapping(value = "atualizar", method = RequestMethod.PUT)
	public ResponseEntity<String> atualizar(@RequestBody @Valid AlunoRequest alunoRequest) {
		return ResponseEntity.status(HttpStatus.OK).body(alunoService.atualizar(alunoRequest));
	}

	@RequestMapping(value = "deletar/cpf={cpf}", method = RequestMethod.DELETE)
	public ResponseEntity<String> atualizar(@RequestBody @PathVariable String cpf) {
		return ResponseEntity.status(HttpStatus.OK).body(alunoService.deletar(cpf));
	}

	@RequestMapping(value = "alterar-senha", method = RequestMethod.PUT)
	public ResponseEntity<String> alterarSenha(@RequestBody AlterarSenha senhaNova)
			throws UnsupportedEncodingException, NoSuchAlgorithmException {
		return ResponseEntity.status(HttpStatus.OK).body(alunoService.alterarSenha(senhaNova));
	}
}
