package com.example.jotas.Aula5.controller;

import com.example.jotas.Aula5.model.Disciplina;
import com.example.jotas.Aula5.model.Estudante;
import com.example.jotas.Aula5.model.dto.DisciplinasInputDTO;
import com.example.jotas.Aula5.service.DisciplinaService;
import com.example.jotas.Aula5.service.EstudanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("estudante")
public class EstudanteController {
    @Autowired
    private EstudanteService estudanteService;

    @PostMapping
    public ResponseEntity<?> criarEstudante(@RequestBody Estudante estudanteInput){

        Estudante estudanteOutput = estudanteService.saveEstudante(estudanteInput);
        URI location = UriComponentsBuilder.
                fromUriString("http://localhost:8080/estudante/{id}").
                buildAndExpand(estudanteOutput.getId()).toUri();

        return ResponseEntity.created(location).build();

    }

    @GetMapping
    public ResponseEntity<List<Estudante>> buscarTodos(){
        List<Estudante> estudantes = estudanteService.getAll();
        return ResponseEntity.ok().body(estudantes);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Estudante> addDisciplina(@PathVariable("id") Long id, @RequestBody DisciplinasInputDTO disciplinasInputDTO){
        Estudante estudante = estudanteService.adicionarDisiciplinas(id, disciplinasInputDTO);
        return ResponseEntity.ok().body(estudante);
    }

}
