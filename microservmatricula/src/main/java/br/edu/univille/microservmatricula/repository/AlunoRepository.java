package br.edu.univille.microservmatricula.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.univille.microservmatricula.entity.Aluno;

@Repository
public interface AlunoRepository extends CrudRepository<Aluno,String>{
    
}
