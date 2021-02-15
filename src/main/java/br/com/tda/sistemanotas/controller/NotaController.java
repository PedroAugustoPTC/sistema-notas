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
import br.com.tda.sistemanotas.model.dto.NotaRequest;
import br.com.tda.sistemanotas.model.dto.Porcentagem;
import br.com.tda.sistemanotas.service.impl.NotaServiceImpl;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("nota")
public class NotaController {
	@Autowired
	NotaServiceImpl notaService;

	@RequestMapping(value = "salvar", method = RequestMethod.POST)
	public ResponseEntity<String> salvar(@RequestBody @Valid List<NotaRequest> notas) {
		return ResponseEntity.status(HttpStatus.CREATED).body(notaService.salvar(notas));
	}

	@RequestMapping(value = "listar", method = RequestMethod.GET)
	public ResponseEntity<List<Nota>> listar() {
		return ResponseEntity.status(HttpStatus.OK).body(notaService.listarTodos());
	}

	@RequestMapping(value = "atualizar", method = RequestMethod.PUT)
	public ResponseEntity<String> atualizar(@RequestBody @Valid Nota nota) {
		return ResponseEntity.status(HttpStatus.OK).body(notaService.atualizar(nota));
	}

	@RequestMapping(value = "deletar/id={id}", method = RequestMethod.DELETE)
	public ResponseEntity<String> atualizar(@RequestBody @PathVariable Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(notaService.deletar(id));
	}

	@RequestMapping(value = "porcentagem/id={id}", method = RequestMethod.GET)
	public ResponseEntity<List<Porcentagem>> porcentagemNota(@RequestBody @PathVariable Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(notaService.porcentagemNota(id));
	}

	@RequestMapping(value = "listar/id={id}", method = RequestMethod.GET)
	public ResponseEntity<Nota> listarPorId(@RequestBody @PathVariable Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(notaService.listarPorId(id));
	}

	@RequestMapping(value = "listar/idAtividade={id}", method = RequestMethod.GET)
	public ResponseEntity<List<Nota>> listarPorAtividade(@RequestBody @PathVariable Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(notaService.listarPorAtividade(id));
	}
}
