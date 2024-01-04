package com.example.jotas.Aula5.controller;

import com.example.jotas.Aula5.model.Pessoa;
import com.example.jotas.Aula5.repository.PessoaRepository;
import com.example.jotas.Aula5.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("pessoa")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @GetMapping
    public ResponseEntity<List<Pessoa>> buscarPessoas(){

        List<Pessoa> pessoas = pessoaService.getPessoas();

        return ResponseEntity.ok().body(pessoas);
    }

    @PostMapping
    public ResponseEntity<?> criarPessoa(Pessoa pessoaInput){

        Pessoa pessoaOutput = pessoaService.savePessoa(pessoaInput);
        URI location = UriComponentsBuilder.
                fromUriString("http://localhost:8080/pessoa/{id}").
                buildAndExpand(pessoaOutput.getId()).toUri();

        return ResponseEntity.created(location).build();

    }
}
