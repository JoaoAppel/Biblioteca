package br.edu.famper.biblioteca.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "bibliotecario")
@Data
public class Bibliotecario {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "bibliotecario_id")
    private Long codigo;

    @Column(name = "nome", length = 100)
    private String nome;

    @Column(name = "cpf", length = 25)
    private String cpf;

    @Column(name = "e-mail", length = 150)
    private String email;

    @Column(name = "telefone", length = 20)
    private String telefone;

    @OneToMany(mappedBy = "bibliotecario", targetEntity = Emprestimo.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Emprestimo> emprestimos;

}
