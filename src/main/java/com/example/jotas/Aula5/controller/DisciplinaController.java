package com.example.jotas.Aula5.controller;

import com.example.jotas.Aula5.model.Disciplina;
import com.example.jotas.Aula5.model.Pessoa;
import com.example.jotas.Aula5.service.DisciplinaService;
import com.example.jotas.Aula5.service.EstudanteService;
import com.example.jotas.Aula5.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("disciplina")
public class DisciplinaController {
    @Autowired
    private DisciplinaService disciplinaService;

    @PostMapping
    public ResponseEntity<?> criarDisciplina(@RequestBody Disciplina disciplinaInput){

        Disciplina disciplinaOutput = disciplinaService.saveDisciplina(disciplinaInput);
        URI location = UriComponentsBuilder.
                fromUriString("http://localhost:8080/disciplina/{id}").
                buildAndExpand(disciplinaOutput.getId()).toUri();

        return ResponseEntity.created(location).build();

    }
}
