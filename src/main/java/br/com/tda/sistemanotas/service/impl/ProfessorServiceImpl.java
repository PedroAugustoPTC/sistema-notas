package br.com.tda.sistemanotas.service.impl;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tda.sistemanotas.model.Professor;
import br.com.tda.sistemanotas.repository.ProfessorRepository;
import br.com.tda.sistemanotas.service.ProfessorService;

@Service
public class ProfessorServiceImpl implements ProfessorService {

	@Autowired
	ProfessorRepository professorRepository;

	@Override
	public Professor salvar(Professor professor) {
		if (professorRepository.existsByCpf(professor.getCpf())) {
			throw new EntityExistsException("Esse professor já existe");
		} else {
			return professorRepository.save(professor);
		}
	}

	@Override
	public List<Professor> listarTodos() {
		return professorRepository.findAll();
	}

	@Override
	public Professor atualizar(Professor professor) {
		if (!(professorRepository.existsByCpf(professor.getCpf()))) {
			throw new NullPointerException("Esse professor não existe");
		} else {
			return professorRepository.save(professor);
		}
	}

	@Override
	public String deletar(String cpf) {
		if (!(professorRepository.existsByCpf(cpf))) {
			throw new NullPointerException("Esse professor não existe");
		} else {
			professorRepository.deleteById((listarPorCpf(cpf)).getId());
			return "Deletado com sucesso";
		}
	}

	@Override
	public Professor listarPorCpf(String cpf) {
		Professor professor = professorRepository.findByCpf(cpf);
		if (professor == null) {
			throw new EntityNotFoundException("Professor não encontrado");
		} else {
			return professor;
		}
	}

	@Override
	public boolean verificaPorCpf(String cpf) {
		return professorRepository.existsByCpf(cpf);
	}

	@Override
	public Professor listarPorId(Long id) {
		Optional<Professor> professor = professorRepository.findById(id);
		if (professor.isPresent()) {
			return professor.get();
		} else {
			throw new EntityNotFoundException("Professor não encontrado");
		}
	}

}
