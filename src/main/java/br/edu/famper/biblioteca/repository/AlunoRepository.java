package br.edu.famper.biblioteca.repository;

import br.edu.famper.biblioteca.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository<Aluno,Long> {
}
