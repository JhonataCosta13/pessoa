package com.example.jotas.Aula5.service;

import com.example.jotas.Aula5.model.Pessoa;
import com.example.jotas.Aula5.model.Telefone;
import com.example.jotas.Aula5.model.dto.PessoaDTO;
import com.example.jotas.Aula5.model.dto.TelefoneDTO;
import com.example.jotas.Aula5.repository.PessoaRepository;
import com.example.jotas.Aula5.repository.TelefoneRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private TelefoneService telefoneService;

    @Autowired
    private ModelMapper modelMapper;

    public Pessoa savePessoa(Pessoa pessoaInput) {

        pessoaRepository.save(pessoaInput);
        telefoneService.salvarTelefones(pessoaInput.getTelefones(), pessoaInput);

        return pessoaInput;
    }

    public List<PessoaDTO> getPessoas() {
        List<Pessoa> pessoas = pessoaRepository.findAll();
        List<PessoaDTO> pessoasDTO = new ArrayList<>();

        pessoasDTO = pessoas.stream().map(p -> modelMapper.map(p, PessoaDTO.class)).toList();

        return pessoasDTO;
    }
}
