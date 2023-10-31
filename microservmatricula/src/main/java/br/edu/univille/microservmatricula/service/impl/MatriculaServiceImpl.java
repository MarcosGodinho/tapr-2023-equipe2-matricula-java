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

        /*
        while(iterador.iterator().hasNext()){
            var umItem = iterador.iterator().next();
            listaMatriculas.add(umItem);
        };
        */

        return listaMatriculas;
    }
}
