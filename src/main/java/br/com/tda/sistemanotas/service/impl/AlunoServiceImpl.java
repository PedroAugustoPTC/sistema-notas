package br.com.tda.sistemanotas.service.impl;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tda.sistemanotas.model.Aluno;
import br.com.tda.sistemanotas.model.Turma;
import br.com.tda.sistemanotas.model.dto.AlterarSenha;
import br.com.tda.sistemanotas.model.dto.AlunoRequest;
import br.com.tda.sistemanotas.model.dto.AlunoResponse;
import br.com.tda.sistemanotas.repository.AlunoRepository;
import br.com.tda.sistemanotas.service.AlunoService;
import br.com.tda.sistemanotas.util.CriptografarSenha;
import br.com.tda.sistemanotas.util.GerarEnviarSenha;

@Service
public class AlunoServiceImpl implements AlunoService {
	@Autowired
	AlunoRepository alunoRepository;

	@Autowired
	GerarEnviarSenha senha;

	@Autowired
	CriptografarSenha criptografarSenha;

	@Autowired
	TurmaServiceImpl turmaService;

	@Override
	public AlunoResponse salvar(AlunoRequest alunoRequest)
			throws UnsupportedEncodingException, NoSuchAlgorithmException {

		alunoRequest.getListaTurma().forEach(item -> {
			if (!turmaService.verificaPorId(item.getId())) {
				throw new NullPointerException("Verifique se a turma" + item.getNome() + " está cadastrada no sistema");
			}
		});

		if (alunoRepository.existsByCpf(alunoRequest.getCpf())) {
			throw new EntityExistsException("Esse aluno já existe");
		} else {
			Aluno aluno = new Aluno();
			aluno.setCpf(alunoRequest.getCpf());
			aluno.setEmail(alunoRequest.getEmail());
			aluno.setNome(alunoRequest.getNome());
			aluno.setMatricula(alunoRequest.getMatricula());
			aluno.setSenha(senha.gerarEviarSenha(alunoRequest.getEmail(), alunoRequest.getNome()));
			aluno.setTurmas(alunoRequest.getListaTurma());
			alunoRepository.save(aluno);

			AlunoResponse alunoResponse = new AlunoResponse(aluno.getNome(), aluno.getMatricula(), aluno.getCpf(),
					aluno.getEmail());
			return alunoResponse;
		}
	}

	@Override
	public List<Aluno> listarTodos() {
		List<Aluno> alunos = alunoRepository.findAll();
		return alunos;
	}

	@Override
	public String atualizar(AlunoRequest alunoRequest) {
		if (!(alunoRepository.existsByCpf(alunoRequest.getCpf()))) {
			throw new NullPointerException("Esse aluno não existe");
		} else {
			Aluno aluno = alunoRepository.findByCpf(alunoRequest.getCpf());
			aluno.setNome(alunoRequest.getNome());
			aluno.setEmail(alunoRequest.getEmail());
			aluno.setCpf(alunoRequest.getCpf());
			aluno.setMatricula(alunoRequest.getMatricula());
			alunoRepository.save(aluno);
			return "Aluno atualizado com sucesso";
		}
	}

	@Override
	public String deletar(String cpf) {
		if (!(alunoRepository.existsByCpf(cpf))) {
			throw new NullPointerException("Esse aluno não existe");
		} else {
			alunoRepository.deleteById((listarPorCpf(cpf)).getId());
			return "Deletado com sucesso";
		}
	}

	@Override
	public Aluno listarPorCpf(String cpf) {
		Aluno aluno = alunoRepository.findByCpf(cpf);
		if (aluno == null) {
			throw new EntityNotFoundException("Aluno não encontrado");
		} else {
			return aluno;
		}
	}

	@Override
	public Aluno listarPorId(Long id) {
		Optional<Aluno> aluno = alunoRepository.findById(id);
		if (aluno.isPresent()) {
			return aluno.get();
		} else {
			throw new EntityNotFoundException("Aluno não encontrado");
		}
	}

	@Override
	public List<Aluno> listarPorIdTurma(Long id) {
		Turma turma = turmaService.listaPorId(id).get();
		return alunoRepository.findByTurmas(turma);
	}

	@Override
	public String alterarSenha(AlterarSenha senhaNova) throws UnsupportedEncodingException, NoSuchAlgorithmException {
		Aluno aluno = listarPorId(senhaNova.getId());

		aluno.setSenha(criptografarSenha.criptografaSenha(senhaNova.getNovaSenha()));

		alunoRepository.save(aluno);
		return "Senha salva com sucesso";
	}
}
