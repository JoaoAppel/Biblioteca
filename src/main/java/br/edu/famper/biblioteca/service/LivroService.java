package br.edu.famper.biblioteca.service;

import br.edu.famper.biblioteca.dto.LivroDto;
import br.edu.famper.biblioteca.model.Livro;
import br.edu.famper.biblioteca.repository.LivroRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class LivroService {

    // buscar um livro

    @Autowired
    private LivroRepository livroRepository;

    public List<LivroDto> getAllLivros() {
        return livroRepository
                .findAll()
                .stream()
                .map(livro -> LivroDto
                        .builder()
                        .titulo(livro.getTitulo())
                        .anoPublicacao(livro.getAnoPublicacao())
                        .build()
                )
                .toList();
    }

    public LivroDto getLivroById(Long id) {
        Livro livro = livroRepository.findById(id).orElseThrow();
        return new LivroDto()
                .builder()
                .titulo(livro.getTitulo())
                .anoPublicacao(livro.getAnoPublicacao())
                .build();
    }

    // inserir um Livro
    public Livro saveLivro(LivroDto livroDto) {
        Livro livro = new Livro();
        livro.setTitulo(livroDto.getTitulo());
        livro.setAnoPublicacao(livroDto.getAnoPublicacao());
        return livroRepository.save(livro);
    }

    // editar um Livro
    public LivroDto editLivro(Long id, LivroDto livroDto) {
        Livro livro = livroRepository.findById(id).orElseThrow();
        livro.setTitulo(livroDto.getTitulo());
        livro.setAnoPublicacao(livroDto.getAnoPublicacao());
        Livro livroEdit = livroRepository.save(livro);
        return new LivroDto()
                .builder()
                .titulo(livro.getTitulo())
                .anoPublicacao(livro.getAnoPublicacao())
                .build();
    }

    // apagar um livro
    public boolean deleteLivro(Long id) {
        try {
            Livro livro = livroRepository.findById(id).orElseThrow();
            livroRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
