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

import com.edu.turmas.turmas.model.Estudante;
import com.edu.turmas.turmas.service.EstudanteService;

@RestController
@RequestMapping("/estudantes")
public class EstudanteController{
    @Autowired
    private EstudanteService estudanteService;

    // Listar todos os estudantees
    @GetMapping
    public ResponseEntity<List<Estudante>> listar() {
        List<Estudante> estudantees = estudanteService.listar();
        return ResponseEntity.ok(estudantees); // Retorna 200 OK
    }

    // Buscar estudante por ID -
    @GetMapping("/{id}")
    public ResponseEntity<Estudante> buscarPorId(@PathVariable Long id) {
        return estudanteService.buscarPorId(id)
                .map(ResponseEntity::ok) // Retorna 200 OK se encontrado
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build()); // Retorna 404 Not Found se não encontrado
    }

    // Criar um novo estudante
    @PostMapping
    public ResponseEntity<Estudante> criar(@RequestBody Estudante estudante) {
        Estudante novoEstudante = estudanteService.salvar(estudante);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoEstudante); // Retorna 201 Created
    }

    // Atualizar um estudante existente
    @PutMapping("/{id}")
    public ResponseEntity<Estudante> atualizar(@PathVariable Long id, @RequestBody Estudante estudante) {
        if (!estudanteService.buscarPorId(id).isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); // Retorna 404 Not Found se o estudante não existir
        }
        estudante.setCodigo(id);
        Estudante estudanteAtualizado = estudanteService.salvar(estudante);
        return ResponseEntity.ok(estudanteAtualizado); // Retorna 200 OK se atualizado com sucesso
    }

    // Deletar um estudante por ID   > localhost:8080/estudantes/1
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        if (!estudanteService.buscarPorId(id).isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); // Retorna 404 Not Found se o estudante não existir
        }
        estudanteService.deletar(id);
        return ResponseEntity.noContent().build(); // Retorna 204 No Content se deletado com sucesso
    }
}
