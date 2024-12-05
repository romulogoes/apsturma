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

import com.edu.turmas.turmas.model.Turma;
import com.edu.turmas.turmas.service.TurmaService;


@RestController
@RequestMapping("/turmas")
public class TurmaController {
    @Autowired
    private TurmaService turmaService;

    // Listar todos os turmaes
    @GetMapping
    public ResponseEntity<List<Turma>> listar() {
        List<Turma> turmaes = turmaService.listar();
        return ResponseEntity.ok(turmaes); // Retorna 200 OK
    }

    // Buscar turma por ID -
    @GetMapping("/{id}")
    public ResponseEntity<Turma> buscarPorId(@PathVariable Long id) {
        return turmaService.buscarPorId(id)
                .map(ResponseEntity::ok) // Retorna 200 OK se encontrado
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build()); // Retorna 404 Not Found se não encontrado
    }

    // Criar um novo turma
    @PostMapping
    public ResponseEntity<Turma> criar(@RequestBody Turma turma) {
        Turma novoTurma = turmaService.salvar(turma);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoTurma); // Retorna 201 Created
    }

    // Atualizar um turma existente
    @PutMapping("/{id}")
    public ResponseEntity<Turma> atualizar(@PathVariable Long id, @RequestBody Turma turma) {
        if (!turmaService.buscarPorId(id).isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); // Retorna 404 Not Found se o turma não existir
        }
        turma.setCodigo(id);
        Turma turmaAtualizado = turmaService.salvar(turma);
        return ResponseEntity.ok(turmaAtualizado); // Retorna 200 OK se atualizado com sucesso
    }

    // Deletar um turma por ID   > localhost:8080/turmas/1
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        if (!turmaService.buscarPorId(id).isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); // Retorna 404 Not Found se o turma não existir
        }
        turmaService.deletar(id);
        return ResponseEntity.noContent().build(); // Retorna 204 No Content se deletado com sucesso
    }
}
