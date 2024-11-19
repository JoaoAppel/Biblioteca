package br.edu.famper.biblioteca.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "aluno")
@Data
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "matricula_id")
    private Long codigo;

    @Column(name = "nome", length = 100)
    private String nome;

    @Column(name = "ano_nascimento")
    private String anoNascimento;

    @Column(name = "status")
    private String status;

    @OneToMany(mappedBy = "aluno", targetEntity = Emprestimo.class,fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Emprestimo> emprestimos;

}
