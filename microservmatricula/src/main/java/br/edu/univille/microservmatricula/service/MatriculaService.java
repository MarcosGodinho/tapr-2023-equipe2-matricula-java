package br.edu.univille.microservmatricula.service;

import java.util.List;
import br.edu.univille.microservmatricula.entity.Matricula;

public interface MatriculaService {

    public List<Matricula> getAll();
    public Matricula saveNew(Matricula matricula);
    public Matricula getById(String id);
    public Matricula update(String id, Matricula matricula);
    public Matricula delete(String id);
}
