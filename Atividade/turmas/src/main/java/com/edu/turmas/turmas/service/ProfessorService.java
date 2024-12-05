package com.edu.turmas.turmas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.turmas.turmas.model.Professor;
import com.edu.turmas.turmas.repository.ProfessorRepository;


@Service
public class ProfessorService {
    @Autowired
    private ProfessorRepository professorRepository;

    public List<Professor> listar() {
        return professorRepository.findAll();
    }

    public Optional<Professor> buscarPorId(Long id) {
        return professorRepository.findById(id);
    }

    public Professor salvar(Professor professor) {
        return professorRepository.save(professor);
    }

    public void deletar(Long id) {
        professorRepository.deleteById(id);
    }
}
