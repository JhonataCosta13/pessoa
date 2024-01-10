package com.example.jotas.Aula5.service;

import com.example.jotas.Aula5.model.Disciplina;
import com.example.jotas.Aula5.model.Estudante;
import com.example.jotas.Aula5.repository.DisciplinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DisciplinaService {
    @Autowired
    private DisciplinaRepository disciplinaRepository;

    public Disciplina saveDisciplina(Disciplina disciplinaInput) {


        return disciplinaRepository.save(disciplinaInput);
    }

    public List<Disciplina> buscarDisciplinasByIds(List<Long> disciplinaIds) {
        return disciplinaRepository.findAllById(disciplinaIds);
    }

    public void vinculaEstudante(List<Disciplina> disciplinas, Estudante estudante) {
        for(Disciplina disciplina : disciplinas){
            disciplina.addEstudante(estudante);
        }
        disciplinaRepository.saveAll(disciplinas);
    }
}
