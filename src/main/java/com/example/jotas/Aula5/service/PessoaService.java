package com.example.jotas.Aula5.service;

import com.example.jotas.Aula5.model.Pessoa;
import com.example.jotas.Aula5.model.Telefone;
import com.example.jotas.Aula5.repository.PessoaRepository;
import com.example.jotas.Aula5.repository.TelefoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private TelefoneService telefoneService;

    public Pessoa savePessoa(Pessoa pessoaInput) {
        List<Telefone> telefones = telefoneService.salvarTelefones(pessoaInput.getTelefones());
        pessoaInput.setTelefones(telefones);
        return pessoaRepository.save(pessoaInput);
    }

    public List<Pessoa> getPessoas() {
        return pessoaRepository.findAll();
    }
}
