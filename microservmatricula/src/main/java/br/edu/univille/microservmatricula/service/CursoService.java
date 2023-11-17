package br.edu.univille.microservmatricula.service;

import java.util.List;
import br.edu.univille.microservmatricula.entity.Curso;

public interface CursoService {

    public List<Curso> getAll();
    public Curso saveNew(Curso curso);
    public Curso getById(String id);
    public Curso update(String id, Curso curso);
    public Curso delete(String id);
}
