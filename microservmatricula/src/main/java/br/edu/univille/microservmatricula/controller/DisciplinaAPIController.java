package br.edu.univille.microservmatricula.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.univille.microservmatricula.entity.Disciplina;
import br.edu.univille.microservmatricula.service.DisciplinaService;

@RestController
@RequestMapping("/api/v1/disciplinas")
public class DisciplinaAPIController {

    @Autowired
    private DisciplinaService service;
    
    @GetMapping
    public ResponseEntity<List<Disciplina>> listaDisciplinas(){

        var listaDisciplinas = service.getAll();

        return new ResponseEntity<List<Disciplina>>(listaDisciplinas, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Disciplina> inserirDisciplina(@RequestBody Disciplina disciplina){
        if(disciplina == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        disciplina = service.saveNew(disciplina);
        return 
            new ResponseEntity<Disciplina>
            (disciplina, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Disciplina> atualizarDisciplina(@PathVariable("id")  String id, @RequestBody Disciplina disciplina){
        if(disciplina == null || id == ""  || id == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        disciplina = service.update(id, disciplina);
        if(disciplina == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return 
            new ResponseEntity<Disciplina>
            (disciplina, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Disciplina> removerDisciplina(@PathVariable("id")  String id){
        if(id == ""  || id == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        var disciplina = service.delete(id);
        if(disciplina == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return 
            new ResponseEntity<Disciplina>
            (disciplina, HttpStatus.OK);
    }
}
