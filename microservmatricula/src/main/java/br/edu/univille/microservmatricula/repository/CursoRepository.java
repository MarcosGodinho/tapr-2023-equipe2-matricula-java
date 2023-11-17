package br.edu.univille.microservmatricula.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.univille.microservmatricula.entity.Curso;

@Repository
public interface CursoRepository extends CrudRepository<Curso,String>{
    
}