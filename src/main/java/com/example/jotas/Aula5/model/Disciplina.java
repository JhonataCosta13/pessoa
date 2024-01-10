package com.example.jotas.Aula5.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table
public class Disciplina {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private Integer duracao;

    @ManyToMany
    @JoinTable(
            name = "disciplina_estudante",
            joinColumns = @JoinColumn(name = "disciplina_id"),
            inverseJoinColumns = @JoinColumn(name = "estudante_id")
    )
    @JsonIgnore
    private List<Estudante> estudantes;

    public void addEstudante(Estudante estudante){
        if(this.estudantes == null){
            this.estudantes = new ArrayList<>();
        }
        this.estudantes.add(estudante);
    }
}
