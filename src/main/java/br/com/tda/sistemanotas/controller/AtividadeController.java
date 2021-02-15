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

import br.com.tda.sistemanotas.model.Atividade;
import br.com.tda.sistemanotas.model.dto.AtividadeDAO;
import br.com.tda.sistemanotas.service.impl.AtividadeServiceImpl;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("atividade")
public class AtividadeController {

	@Autowired
	AtividadeServiceImpl atividadeService;

	@RequestMapping(value = "salvar", method = RequestMethod.POST)
	public ResponseEntity<Atividade> salvar(@RequestBody @Valid AtividadeDAO atividade) {
		return ResponseEntity.status(HttpStatus.CREATED).body(atividadeService.salvar(atividade));
	}

	@RequestMapping(value = "listar", method = RequestMethod.GET)
	public ResponseEntity<List<Atividade>> listar() {
		return ResponseEntity.status(HttpStatus.OK).body(atividadeService.listarTodos());
	}

	@RequestMapping(value = "atualizar", method = RequestMethod.PUT)
	public ResponseEntity<Atividade> atualizar(@RequestBody @Valid Atividade atividade) {
		return ResponseEntity.status(HttpStatus.OK).body(atividadeService.atualizar(atividade));
	}

	@RequestMapping(value = "deletar/id={id}", method = RequestMethod.PUT)
	public ResponseEntity<String> deletar(@RequestBody Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(atividadeService.deletar(id));
	}

	@RequestMapping(value = "listar/id={id}", method = RequestMethod.GET)
	public ResponseEntity<Atividade> listarPorId(@RequestBody @PathVariable Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(atividadeService.listarPorId(id));
	}

	@RequestMapping(value = "listar/idTurma={id}", method = RequestMethod.GET)
	public ResponseEntity<List<Atividade>> listarPorTurma(@RequestBody @PathVariable Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(atividadeService.listarPorTurmaId(id));
	}
}
