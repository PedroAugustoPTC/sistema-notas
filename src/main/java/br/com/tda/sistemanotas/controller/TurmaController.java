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

import br.com.tda.sistemanotas.model.Turma;
import br.com.tda.sistemanotas.model.dto.TurmaRequest;
import br.com.tda.sistemanotas.service.impl.TurmaServiceImpl;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("turma")
public class TurmaController {

	@Autowired
	TurmaServiceImpl turmaService;

	@RequestMapping(value = "salvar", method = RequestMethod.POST)
	public ResponseEntity<String> salvar(@RequestBody @Valid TurmaRequest turmaRequest)
			throws UnsupportedEncodingException, NoSuchAlgorithmException {
		return ResponseEntity.status(HttpStatus.CREATED).body(turmaService.salvar(turmaRequest));
	}

	@RequestMapping(value = "listar", method = RequestMethod.GET)
	public ResponseEntity<List<Turma>> listar() {
		return ResponseEntity.status(HttpStatus.OK).body(turmaService.listarTodos());
	}

	@RequestMapping(value = "atualizar", method = RequestMethod.PUT)
	public ResponseEntity<Turma> atualizar(@RequestBody @Valid Turma turma) {
		return ResponseEntity.status(HttpStatus.OK).body(turmaService.atualizar(turma));
	}

	@RequestMapping(value = "deletar/id={id}", method = RequestMethod.DELETE)
	public ResponseEntity<String> atualizar(@RequestBody @PathVariable Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(turmaService.deletar(id));
	}

	@RequestMapping(value = "listar/id={id}", method = RequestMethod.GET)
	public ResponseEntity<Turma> listarPorId(@RequestBody @PathVariable Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(turmaService.listarPorId(id));
	}
}
