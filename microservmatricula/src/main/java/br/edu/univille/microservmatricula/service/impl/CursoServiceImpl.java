package br.edu.univille.microservmatricula.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import br.edu.univille.microservmatricula.entity.Curso;
import br.edu.univille.microservmatricula.repository.CursoRepository;
import br.edu.univille.microservmatricula.service.CursoService;

@Service
public class CursoServiceImpl implements CursoService{

    @Autowired
    private CursoRepository repository;

    @Override
    public List<Curso> getAll() {
        
        var iterador = repository.findAll();
        List<Curso> listaCursos = new ArrayList<>();

        iterador.forEach(listaCursos::add);

        return listaCursos;
    }

    @Override
    public Curso saveNew(Curso curso) {
	    curso.setId(null);
	    return repository.save(curso);
    }

    @Override
    public Curso getById(String id) {
        var curso = repository.findById(id);
        if(curso.isPresent())
            return curso.get();
        return null;
    }

    @Override
    public Curso update(String id, Curso curso) {
        var buscaCursoAntigo = repository.findById(id);
        if (buscaCursoAntigo.isPresent()){
            var cursoNovo = buscaCursoAntigo.get();

            cursoNovo.setNome(curso.getNome());

            return repository.save(cursoNovo);
        }
        return null;
    }

    @Override
    public Curso delete(String id) {
        var buscaCurso = repository.findById(id);
        if (buscaCurso.isPresent()){
            var curso = buscaCurso.get();

            repository.delete(curso);

            return curso;
        }
        return null;
    }

}
