package br.edu.famper.biblioteca.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "livro")
@Data
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "livro_id")
    private Long codigo;

    @Column(name = "titulo", length = 100)
    private String titulo;

    @Column(name = "ano_publicacao")
    private String anoPublicacao;

    @ManyToOne
    @JoinColumn(name = "autor_id")
    private Autor autor;

    @OneToMany(mappedBy = "livro", targetEntity = Emprestimo.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Emprestimo> emprestimos;

}
