package br.edu.univille.microservmatricula.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.univille.microservmatricula.entity.Matricula;
import br.edu.univille.microservmatricula.service.MatriculaService;

@RestController
@RequestMapping("/api/v1/matriculas")
public class MatriculaAPIController {

    @Autowired
    private MatriculaService service;
    
    @GetMapping
    public ResponseEntity<List<Matricula>> listaMatriculas(){

        var listaMatriculas = service.getAll();

        return new ResponseEntity<List<Matricula>>(listaMatriculas, HttpStatus.OK);
    }
}
