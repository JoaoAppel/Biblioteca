package br.edu.famper.biblioteca.repository;

import br.edu.famper.biblioteca.model.Bibliotecario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BibliotecarioRepository extends JpaRepository<Bibliotecario,Long> {
}
