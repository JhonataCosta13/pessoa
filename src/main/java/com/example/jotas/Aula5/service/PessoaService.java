package com.example.jotas.Aula5.service;

import com.example.jotas.Aula5.model.Pessoa;
import com.example.jotas.Aula5.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    public Pessoa savePessoa(Pessoa pessoaInput) {
        return pessoaRepository.save(pessoaInput);
    }

    public List<Pessoa> getPessoas() {
        return pessoaRepository.findAll();
    }
}
