package br.edu.univille.microservmatricula.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import br.edu.univille.microservmatricula.entity.Matricula;
import br.edu.univille.microservmatricula.repository.MatriculaRepository;
import br.edu.univille.microservmatricula.service.MatriculaService;

@Service
public class MatriculaServiceImpl implements MatriculaService{

    @Autowired
    private MatriculaRepository repository;

    @Override
    public List<Matricula> getAll() {
        
        var iterador = repository.findAll();
        List<Matricula> listaMatriculas = new ArrayList<>();

        iterador.forEach(listaMatriculas::add);

        return listaMatriculas;
    }

    @Override
    public Matricula saveNew(Matricula matricula) {
	    matricula.setIdMatricula(null);
	    return repository.save(matricula);
    }

    @Override
    public Matricula getById(String id) {
        var carro = repository.findById(id);
        if(carro.isPresent())
            return carro.get();
        return null;
    }

    @Override
    public Matricula update(String id, Matricula matricula) {
        var buscaMatriculaAntiga = repository.findById(id);
        if (buscaMatriculaAntiga.isPresent()){
            var matriculaNova = buscaMatriculaAntiga.get();

            matriculaNova.setCPF(matricula.getCPF());
            matriculaNova.setDataIngresso(matricula.getDataIngresso());

            return repository.save(matriculaNova);
        }
        return null;
    }

    @Override
    public Matricula delete(String id) {
        var buscaMatricula = repository.findById(id);
        if (buscaMatricula.isPresent()){
            var matricula = buscaMatricula.get();

            repository.delete(matricula);

            return matricula;
        }
        return null;
    }

}
