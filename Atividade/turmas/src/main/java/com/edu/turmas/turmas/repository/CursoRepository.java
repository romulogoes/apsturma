package com.edu.turmas.turmas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edu.turmas.turmas.model.Curso;

public interface CursoRepository extends JpaRepository<Curso,Long> {

}
