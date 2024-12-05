package com.edu.turmas.turmas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.turmas.turmas.model.Turma;
import com.edu.turmas.turmas.repository.TurmaRepository;

@Service
public class TurmaService {
    @Autowired
    private TurmaRepository turmaRepository;

    public List<Turma> listar() {
        return turmaRepository.findAll();
    }

    public Optional<Turma> buscarPorId(Long id) {
        return turmaRepository.findById(id);
    }

    public Turma salvar(Turma turma) {
        return turmaRepository.save(turma);
    }

    public void deletar(Long id) {
        turmaRepository.deleteById(id);
    }
}
