package br.edu.univille.microservmatricula.service;

import java.util.List;
import br.edu.univille.microservmatricula.entity.Aluno;

public interface AlunoService {

    public List<Aluno> getAll();
    public Aluno saveNew(Aluno Aluno);
    public Aluno getById(String id);
    public Aluno update(String id, Aluno Aluno);
    public Aluno delete(String id);
}
