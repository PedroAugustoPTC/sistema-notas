package br.com.tda.sistemanotas.service.impl;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tda.sistemanotas.error.exception.ValorMaximoException;
import br.com.tda.sistemanotas.model.Atividade;
import br.com.tda.sistemanotas.model.Turma;
import br.com.tda.sistemanotas.model.dto.AtividadeDAO;
import br.com.tda.sistemanotas.repository.AtividadeRepository;
import br.com.tda.sistemanotas.service.AtividadeService;
import br.com.tda.sistemanotas.util.DateFormatter;

@Service
public class AtividadeServiceImpl implements AtividadeService {

	@Autowired
	AtividadeRepository atividadeRepository;

	@Autowired
	TurmaServiceImpl turmaService;

	@Autowired
	DateFormatter formatarData;

	@Override
	public Atividade salvar(AtividadeDAO atividadeRequest) {
		if (turmaService.listaPorId(atividadeRequest.getTurma().getId()).isEmpty()) {
			throw new EntityNotFoundException("Turma não encontrada");
		}
		Atividade atividade = new Atividade();
		atividade.setDescricao(atividadeRequest.getDescricao());
		atividade.setTurma(atividadeRequest.getTurma());
		atividade.setValor(atividadeRequest.getValor());
		verificaValorMaximo(atividade.getTurma(), atividade.getValor());
		atividade.setData(formatarData.formatarDataParaOBanco(atividadeRequest.getData()));
		return atividadeRepository.save(atividade);
	}

	@Override
	public List<Atividade> listarTodos() {
		return atividadeRepository.findAll();
	}

	@Override
	public Atividade atualizar(Atividade atividade) {
		if (atividadeRepository.existsById(atividade.getId())) {
			return atividadeRepository.save(atividade);
		} else {
			throw new EntityNotFoundException("Atividade não existe");
		}
	}

	@Override
	public String deletar(Long id) {
		if (atividadeRepository.existsById(id)) {
			atividadeRepository.deleteById(id);
			return "Deletado com sucesso";
		} else {
			throw new EntityNotFoundException("Atividade não existe");
		}

	}

	@Override
	public Atividade listarPorDescricao(String atividadeDescricao) {
		Atividade atividade = atividadeRepository.findByDescricao(atividadeDescricao);
		if (atividade != null) {
			return atividade;
		} else {
			throw new NullPointerException("Atividade não encontrada");
		}
	}

	@Override
	public void verificaValorMaximo(Turma turma, Double valor) {
		List<Atividade> obj = atividadeRepository.findByTurma(turma);
		Double soma = 0.0;
		for (int i = 0; i < obj.size(); i++) {
			soma += obj.get(i).getValor();
		}

		if (soma + valor > 100.0)
			throw new ValorMaximoException("O valor total de notas desta turma ultrapassou 100.0 pontos");
	}

	@Override
	public List<Atividade> listarPorTurma(Turma turma) {
		List<Atividade> retorno = atividadeRepository.findByTurma(turma);
		if (retorno.isEmpty()) {
			throw new EntityNotFoundException("Atividade não encontrado");
		}
		return retorno;

	}

	@Override
	public Atividade listarPorId(Long id) {
		Optional<Atividade> atividade = atividadeRepository.findById(id);
		if (atividade.isPresent()) {
			return atividade.get();
		} else {
			throw new EntityNotFoundException("Atividade não encontrado");
		}
	}

	public List<Atividade> listarPorTurmaId(Long id) {

		return listarPorTurma(turmaService.listarPorId(id));
	}

}
