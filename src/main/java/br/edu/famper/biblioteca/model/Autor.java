package br.edu.famper.biblioteca.model;


import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "autor")
@Data
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "autor_id")
    private Long codigo;

    @Column(name = "nome", length = 100)
    private String nome;

    @Column(name = "nacionalidade", length = 100)
    private String nacionalidade;

    @Column(name = "data_nascimento")
    private Date dataNascimento;

    @OneToMany(mappedBy = "autor", targetEntity = Livro.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Livro> livros;

}
