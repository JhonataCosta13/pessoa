package com.example.jotas.Aula5.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Entity
@Table
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String genero;
    private LocalDate dataNascimento;

    @OneToMany(mappedBy = "pessoa")
    private List<Telefone> telefones;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "documento_id")
    private Documento documento;
}
