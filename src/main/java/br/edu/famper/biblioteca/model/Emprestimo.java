package br.edu.famper.biblioteca.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "emprestimo")
@Data
public class Emprestimo {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "emprestimo_id")
    private Long codigo;

    @Column(name = "data_emprestimo")
    @Temporal(TemporalType.DATE)
    private Date dataEmprestimo;

    @Column(name = "data_devolucao")
    @Temporal(TemporalType.DATE)
    private Date datadevolucao;

    @Column(name = "status")
    private String status;

    @ManyToOne
    @JoinColumn(name = "aluno_id")
    private Aluno aluno;

    @ManyToOne
    @JoinColumn(name = "livro_id")
    private Livro livro;

    @ManyToOne
    @JoinColumn(name = "bibliotecario_id")
    private Bibliotecario bibliotecario;

}
