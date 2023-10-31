package br.edu.univille.microservmatricula.service;

import java.util.List;
import br.edu.univille.microservmatricula.entity.Matricula;

public interface MatriculaService {
    public List<Matricula> getAll();
}
