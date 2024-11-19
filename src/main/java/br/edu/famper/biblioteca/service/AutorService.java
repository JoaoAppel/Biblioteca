package br.edu.famper.biblioteca.service;

import br.edu.famper.biblioteca.dto.AutorDto;
import br.edu.famper.biblioteca.model.Autor;
import br.edu.famper.biblioteca.repository.AutorRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class AutorService {

    // buscar um autor

    @Autowired
    private AutorRepository autorRepository;

    public List<AutorDto> getAllAutors() {
        return autorRepository
                .findAll()
                .stream()
                .map(autor -> AutorDto
                        .builder()
                        .nome(autor.getNome())
                        .nacionalidade(autor.getNacionalidade())
                        .dataNascimento(autor.getDataNascimento())
                        .build()
                )
                .toList();
    }

    public AutorDto getAutorById(Long id) {
        Autor autor = autorRepository.findById(id).orElseThrow();
        return new AutorDto()
                .builder()
                .nome(autor.getNome())
                .nacionalidade(autor.getNacionalidade())
                .dataNascimento(autor.getDataNascimento())
                .build();
    }

    // inserir um Autor
    public Autor saveAutor(AutorDto autorDto) {
        Autor autor = new Autor();
        autor.setNome(autorDto.getNome());
        autor.setNacionalidade(autorDto.getNacionalidade());
        autor.setDataNascimento(autorDto.getDataNascimento());
        return autorRepository.save(autor);
    }

    // editar um Autor
    public AutorDto editAutor(Long id, AutorDto autorDto) {
        Autor autor = autorRepository.findById(id).orElseThrow();
        autor.setNome(autorDto.getNome());
        autor.setNacionalidade(autorDto.getNacionalidade());
        autor.setDataNascimento(autorDto.getDataNascimento());
        Autor autorEdit = autorRepository.save(autor);
        return new AutorDto()
                .builder()
                .nome(autor.getNome())
                .nacionalidade(autor.getNacionalidade())
                .dataNascimento(autor.getDataNascimento())
                .build();
    }

    // apagar um autor
    public boolean deleteAutor(Long id) {
        try {
            Autor autor = autorRepository.findById(id).orElseThrow();
            autorRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
