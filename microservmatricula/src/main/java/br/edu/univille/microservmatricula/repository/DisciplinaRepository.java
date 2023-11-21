package br.edu.univille.microservmatricula.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.univille.microservmatricula.entity.Disciplina;

@Repository
public interface DisciplinaRepository extends CrudRepository<Disciplina,String>{
    
}
