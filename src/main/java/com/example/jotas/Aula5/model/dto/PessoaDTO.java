package com.example.jotas.Aula5.model.dto;

import com.example.jotas.Aula5.model.Telefone;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class PessoaDTO {
    private Long id;
    private String nome;
    private String email;
    private String genero;
    private LocalDate dataNascimento;
    private List<TelefoneDTO> telefones;

}
