package br.edu.univille.microservmatricula.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import br.edu.univille.microservmatricula.entity.Disciplina;
import br.edu.univille.microservmatricula.repository.DisciplinaRepository;
import br.edu.univille.microservmatricula.service.DisciplinaService;

@Service
public class DisciplinaServiceImpl implements DisciplinaService{

    @Autowired
    private DisciplinaRepository repository;

    @Override
    public List<Disciplina> getAll() {
        
        var iterador = repository.findAll();
        List<Disciplina> listaDisciplinas = new ArrayList<>();

        iterador.forEach(listaDisciplinas::add);

        return listaDisciplinas;
    }

    @Override
    public Disciplina saveNew(Disciplina disciplina) {
	    disciplina.setId(null);
	    return repository.save(disciplina);
    }

    @Override
    public Disciplina getById(String id) {
        var disciplina = repository.findById(id);
        if(disciplina.isPresent())
            return disciplina.get();
        return null;
    }

    @Override
    public Disciplina update(String id, Disciplina disciplina) {
        var buscaDisciplinaAntigo = repository.findById(id);
        if (buscaDisciplinaAntigo.isPresent()){
            var disciplinaNovo = buscaDisciplinaAntigo.get();

            disciplinaNovo.setNome(disciplina.getNome());

            return repository.save(disciplinaNovo);
        }
        return null;
    }

    @Override
    public Disciplina delete(String id) {
        var buscaDisciplina = repository.findById(id);
        if (buscaDisciplina.isPresent()){
            var disciplina = buscaDisciplina.get();

            repository.delete(disciplina);

            return disciplina;
        }
        return null;
    }

}
