package br.edu.univille.microservmatricula.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.univille.microservmatricula.entity.Matricula;

@RestController
@RequestMapping("/api/v1/matriculas")
public class MatriculaAPIController {
    @GetMapping
    public ResponseEntity<List<Matricula>> listaMatriculas(){
        var listaMatriculas = new ArrayList<Matricula>();

        return new ResponseEntity<List<Matricula>>(listaMatriculas, HttpStatus.OK);
    }
}
