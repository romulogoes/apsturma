package com.edu.turmas.turmas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edu.turmas.turmas.model.Professor;
import com.edu.turmas.turmas.service.ProfessorService;


@RestController
@RequestMapping("/professores")
public class ProfessorController {
    @Autowired
    private ProfessorService professorService;

    // Listar todos os professores
    @GetMapping
    public ResponseEntity<List<Professor>> listar() {
        List<Professor> professores = professorService.listar();
        return ResponseEntity.ok(professores); // Retorna 200 OK
    }

    // Buscar professor por ID -
    @GetMapping("/{id}")
    public ResponseEntity<Professor> buscarPorId(@PathVariable Long id) {
        return professorService.buscarPorId(id)
                .map(ResponseEntity::ok) // Retorna 200 OK se encontrado
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build()); // Retorna 404 Not Found se não encontrado
    }

    // Criar um novo professor
    @PostMapping
    public ResponseEntity<Professor> criar(@RequestBody Professor professor) {
        Professor novoProfessor = professorService.salvar(professor);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoProfessor); // Retorna 201 Created
    }

    // Atualizar um professor existente
    @PutMapping("/{id}")
    public ResponseEntity<Professor> atualizar(@PathVariable Long id, @RequestBody Professor professor) {
        if (!professorService.buscarPorId(id).isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); // Retorna 404 Not Found se o professor não existir
        }
        professor.setCodigo(id);
        Professor professorAtualizado = professorService.salvar(professor);
        return ResponseEntity.ok(professorAtualizado); // Retorna 200 OK se atualizado com sucesso
    }

    // Deletar um professor por ID   > localhost:8080/professors/1
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        if (!professorService.buscarPorId(id).isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); // Retorna 404 Not Found se o professor não existir
        }
        professorService.deletar(id);
        return ResponseEntity.noContent().build(); // Retorna 204 No Content se deletado com sucesso
    }
}
