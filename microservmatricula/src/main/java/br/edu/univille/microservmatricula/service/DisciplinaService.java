package br.edu.univille.microservmatricula.service;

import java.util.List;
import br.edu.univille.microservmatricula.entity.Disciplina;

public interface DisciplinaService {

    public List<Disciplina> getAll();
    public Disciplina saveNew(Disciplina Disciplina);
    public Disciplina getById(String id);
    public Disciplina update(String id, Disciplina Disciplina);
    public Disciplina delete(String id);
    public Disciplina update(Disciplina disciplina);
}
