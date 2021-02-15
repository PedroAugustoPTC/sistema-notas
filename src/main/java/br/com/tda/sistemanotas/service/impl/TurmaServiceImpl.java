package br.com.tda.sistemanotas.service.impl;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tda.sistemanotas.model.Aluno;
import br.com.tda.sistemanotas.model.Turma;
import br.com.tda.sistemanotas.model.dto.TurmaRequest;
import br.com.tda.sistemanotas.repository.TurmaRepository;
import br.com.tda.sistemanotas.service.TurmaService;

@Service
public class TurmaServiceImpl implements TurmaService {

	@Autowired
	TurmaRepository turmaRepository;

	@Autowired
	ProfessorServiceImpl professorService;

	@Override
	public String salvar(TurmaRequest turmaRequest) {
		if (!professorService.verificaPorCpf(turmaRequest.getProfessor().getCpf())) {
			throw new EntityNotFoundException("Professor nao existe");
		} else if (turmaRepository.existsByNome(turmaRequest.getNome())) {
			throw new EntityExistsException("Está turma já está cadastrada");
		}
		Turma turma = new Turma(turmaRequest.getNome(), turmaRequest.getSemestre(), turmaRequest.getAno(),
				turmaRequest.getProfessor());
		turmaRepository.save(turma);
		return "Turma " + turma.getNome() + " do professor " + turma.getProfessor().getNome() + " salva com sucesso";
	}

	@Override
	public Turma atualizar(Turma turma) {
		if (!professorService.verificaPorCpf(turma.getProfessor().getCpf())) {
			throw new EntityNotFoundException("Professor nao existe");
		} else if (turmaRepository.existsByNome(turma.getNome())) {
			throw new EntityExistsException("Está turma já está cadastrada");
		}

		return turmaRepository.save(turma);
	}

	@Override
	public List<Turma> listarTodos() {
		return turmaRepository.findAll();
	}

	@Override
	public String deletar(Long id) {
		turmaRepository.deleteById(id);
		return "Turma deletada com sucesso";
	}

	@Override
	public Turma listarPorNome(String nome) {
		Turma turma = turmaRepository.findByNome(nome);
		if (turma != null) {
			return turma;
		} else {
			throw new NullPointerException("Turma não encontrada");
		}
	}

	@Override
	public boolean verificaPorId(Long id) {

		return turmaRepository.existsById(id);
	}

	@Override
	public Optional<Turma> listaPorId(Long id) {
		return turmaRepository.findById(id);
	}

	@Override
	public List<Turma> listaPorAluno(Aluno aluno) {

		return turmaRepository.findByAlunos(aluno);
	}

	@Override
	public Turma listarPorId(Long id) {
		Optional<Turma> turma = turmaRepository.findById(id);
		if (turma.isPresent()) {
			return turma.get();
		} else {
			throw new EntityNotFoundException("Turma não encontrado");
		}
	}

}
