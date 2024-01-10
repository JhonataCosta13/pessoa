package com.example.jotas.Aula5.service;

import com.example.jotas.Aula5.model.Disciplina;
import com.example.jotas.Aula5.model.Estudante;
import com.example.jotas.Aula5.model.dto.DisciplinasInputDTO;
import com.example.jotas.Aula5.repository.EstudanteRepository;
import com.example.jotas.Aula5.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstudanteService {
    @Autowired
    private EstudanteRepository estudanteRepository;

    @Autowired
    private DisciplinaService disciplinaService;

    public Estudante saveEstudante(Estudante estudanteInput) {
        return estudanteRepository.save(estudanteInput);
    }

    public List<Estudante> getAll() {
        return estudanteRepository.findAll();
    }

    public Estudante adicionarDisiciplinas(Long id, DisciplinasInputDTO disciplinaIds) {
        Estudante estudante = estudanteRepository.findById(id).get();
        List<Disciplina> disciplinas = disciplinaService.buscarDisciplinasByIds(disciplinaIds.getDisciplinasIds().stream().toList());
        disciplinaService.vinculaEstudante(disciplinas, estudante);
        estudante.setDisciplinas(disciplinas);
        return estudanteRepository.save(estudante);
    }
}
