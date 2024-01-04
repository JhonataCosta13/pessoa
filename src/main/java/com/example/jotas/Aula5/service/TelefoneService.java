package com.example.jotas.Aula5.service;

import com.example.jotas.Aula5.model.Telefone;
import com.example.jotas.Aula5.repository.TelefoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TelefoneService {

    @Autowired
    private TelefoneRepository telefoneRepository;

    public List<Telefone> salvarTelefones(List<Telefone> telefones){
        return telefoneRepository.saveAll(telefones);
    }
}
