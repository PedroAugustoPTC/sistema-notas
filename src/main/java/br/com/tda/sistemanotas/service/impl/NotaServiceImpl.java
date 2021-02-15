package br.com.tda.sistemanotas.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tda.sistemanotas.model.Aluno;
import br.com.tda.sistemanotas.model.Atividade;
import br.com.tda.sistemanotas.model.Nota;
import br.com.tda.sistemanotas.model.Turma;
import br.com.tda.sistemanotas.model.dto.NotaRequest;
import br.com.tda.sistemanotas.model.dto.Porcentagem;
import br.com.tda.sistemanotas.repository.NotaRepository;
import br.com.tda.sistemanotas.service.NotaService;

@Service
public class NotaServiceImpl implements NotaService {

	@Autowired
	NotaRepository notaRepository;

	@Autowired
	AtividadeServiceImpl atividadeService;

	@Autowired
	AlunoServiceImpl alunoService;

	@Autowired
	TurmaServiceImpl turmaService;

	@Override
	public String salvar(List<NotaRequest> notas) {
		notas.forEach(item -> {
			Aluno aluno = alunoService.listarPorCpf(item.getCpf());
			Atividade atividade = atividadeService.listarPorDescricao(item.getDescricao());
			Nota nota = new Nota();
			nota.setAluno(aluno);
			nota.setAtividade(atividade);
			nota.setValor(item.getValor());
			notaRepository.save(nota);
		});
		return "Notas salvas com sucesso";
	}

	@Override
	public String atualizar(Nota nota) {
		notaRepository.save(nota);
		return "Nota atualizada com sucesso";
	}

	@Override
	public List<Nota> listarTodos() {
		return notaRepository.findAll();
	}

	@Override
	public String deletar(Long id) {
		if (notaRepository.existsById(id)) {
			notaRepository.deleteById(id);
		} else {
			throw new NullPointerException("Nota inexistente");
		}
		return "Deletado com sucesso";
	}

	@Override
	public Double calculaPorcentagem(Turma turma, Aluno aluno) {
		List<Atividade> atividadesTurma = atividadeService.listarPorTurma(turma);
		Double somaTurma = 0.0;
		Double somaAluno = 0.0;
		for (int i = 0; i < atividadesTurma.size(); i++) {
			somaTurma += atividadesTurma.get(i).getValor();

			List<Nota> nota = notaRepository.findByAtividade(atividadesTurma.get(i));

			for (int j = 0; j < nota.size(); j++) {
				if (nota.get(j).getAluno().equals(aluno))
					somaAluno += nota.get(j).getValor();
			}
		}
		return (somaAluno * 100) / somaTurma;
	}

	@Override
	public List<Porcentagem> porcentagemNota(Long id) {
		List<Porcentagem> listaPorcentagem = new ArrayList<Porcentagem>();

		Aluno aluno = alunoService.listarPorId(id);

		for (int i = 0; i < aluno.getTurmas().size(); i++) {
			Porcentagem porcentagem = new Porcentagem();
			porcentagem.setPorcentagem(calculaPorcentagem(aluno.getTurmas().get(i), aluno));
			porcentagem.setNomeTurma(aluno.getTurmas().get(i).getNome());
			listaPorcentagem.add(porcentagem);
		}
		return listaPorcentagem;
	}

	@Override
	public Nota listarPorId(Long id) {
		Optional<Nota> nota = notaRepository.findById(id);
		if (nota.isPresent()) {
			return nota.get();
		} else {
			throw new EntityNotFoundException("Nota não encontrado");
		}
	}

	public List<Nota> listarPorAtividade(Long id) {
		return notaRepository.findByAtividade(atividadeService.listarPorId(id));
	}
}