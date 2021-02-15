package br.com.tda.sistemanotas.controller;

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

import br.com.tda.sistemanotas.model.Nota;
import br.com.tda.sistemanotas.model.Professor;
import br.com.tda.sistemanotas.service.impl.ProfessorServiceImpl;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("professor")
public class ProfessorController {

	@Autowired
	ProfessorServiceImpl professorService;

	@RequestMapping(value = "salvar", method = RequestMethod.POST)
	public ResponseEntity<Professor> salvar(@RequestBody @Valid Professor professor) {
		return ResponseEntity.status(HttpStatus.CREATED).body(professorService.salvar(professor));
	}

	@RequestMapping(value = "listar", method = RequestMethod.GET)
	public ResponseEntity<List<Professor>> listar() {
		return ResponseEntity.status(HttpStatus.OK).body(professorService.listarTodos());
	}

	@RequestMapping(value = "atualizar", method = RequestMethod.PUT)
	public ResponseEntity<Professor> atualizar(@RequestBody @Valid Professor professor) {
		return ResponseEntity.status(HttpStatus.OK).body(professorService.atualizar(professor));
	}

	@RequestMapping(value = "deletar/cpf={cpf}", method = RequestMethod.DELETE)
	public ResponseEntity<String> atualizar(@RequestBody @PathVariable String cpf) {
		return ResponseEntity.status(HttpStatus.OK).body(professorService.deletar(cpf));
	}

	@RequestMapping(value = "listar/id={id}", method = RequestMethod.GET)
	public ResponseEntity<Professor> listarPorId(@RequestBody @PathVariable Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(professorService.listarPorId(id));
	}
}
