package br.edu.univille.microservmatricula.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


import br.edu.univille.microservmatricula.entity.Matricula;
import br.edu.univille.microservmatricula.repository.MatriculaRepository;
import br.edu.univille.microservmatricula.service.MatriculaService;

import io.dapr.client.DaprClient;
import io.dapr.client.DaprClientBuilder;

@Service
public class MatriculaServiceImpl implements MatriculaService{

    @Autowired
    private MatriculaRepository repository;

    private DaprClient client = new DaprClientBuilder().build();
    
    @Value("${app.component.topic.matricula}")
    private String TOPIC_NAME;
    
    @Value("${app.component.service}")
	private String PUBSUB_NAME;

    //método privado para publicar a atualização
    private void publicarAtualizacao(Matricula matricula){
        client.publishEvent(
					PUBSUB_NAME,
					TOPIC_NAME,
					matricula).block();
    }

    @Override
    public List<Matricula> getAll() {
        
        var iterador = repository.findAll();
        List<Matricula> listaMatriculas = new ArrayList<>();

        iterador.forEach(listaMatriculas::add);

        return listaMatriculas;
    }

    @Override
    public Matricula saveNew(Matricula matricula) {
	    matricula.setID(null);
        matricula = repository.save(matricula);
        publicarAtualizacao(matricula);
	    return repository.save(matricula);
    }

    @Override
    public Matricula getById(String id) {
        var matricula = repository.findById(id);
        if(matricula.isPresent())
            return matricula.get();
        return null;
    }

    @Override
    public Matricula update(String id, Matricula matricula) {
        var buscaMatriculaAntiga = repository.findById(id);
        if (buscaMatriculaAntiga.isPresent()){
            var matriculaNova = buscaMatriculaAntiga.get();

            matriculaNova.setCPF(matricula.getCPF());
            matriculaNova.setDataIngresso(matricula.getDataIngresso());
            matriculaNova.setPeriodoCursando(matricula.getPeriodoCursando());
            matriculaNova = repository.save(matriculaNova);
            publicarAtualizacao(matriculaNova);
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
