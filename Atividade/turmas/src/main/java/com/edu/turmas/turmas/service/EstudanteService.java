package com.edu.turmas.turmas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.turmas.turmas.model.Estudante;
import com.edu.turmas.turmas.repository.EstudanteRepository;

@Service
public class EstudanteService{
    @Autowired
    private EstudanteRepository estudanteRepository;

    public List<Estudante> listar() {
        return estudanteRepository.findAll();
    }

    public Optional<Estudante> buscarPorId(Long id) {
        return estudanteRepository.findById(id);
    }

    public Estudante salvar(Estudante estudante) {
        return estudanteRepository.save(estudante);
    }

    public void deletar(Long id) {
        estudanteRepository.deleteById(id);
    }
}
