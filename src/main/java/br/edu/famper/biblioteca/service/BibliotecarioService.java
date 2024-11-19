package br.edu.famper.biblioteca.service;

import br.edu.famper.biblioteca.dto.BibliotecarioDto;
import br.edu.famper.biblioteca.model.Bibliotecario;
import br.edu.famper.biblioteca.repository.BibliotecarioRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class BibliotecarioService {

    // buscar um bibliotecario

    @Autowired
    private BibliotecarioRepository bibliotecarioRepository;

    public List<BibliotecarioDto> getAllBibliotecarios() {
        return bibliotecarioRepository
                .findAll()
                .stream()
                .map(bibliotecario -> BibliotecarioDto
                        .builder()
                        .nome(bibliotecario.getNome())
                        .cpf(bibliotecario.getCpf())
                        .email(bibliotecario.getEmail())
                        .telefone(bibliotecario.getTelefone())
                        .build()
                )
                .toList();
    }

    public BibliotecarioDto getBibliotecarioById(Long id) {
        Bibliotecario bibliotecario = bibliotecarioRepository.findById(id).orElseThrow();
        return new BibliotecarioDto()
                .builder()
                .nome(bibliotecario.getNome())
                .cpf(bibliotecario.getCpf())
                .email(bibliotecario.getEmail())
                .telefone(bibliotecario.getTelefone())
                .build();
    }

    // inserir um Bibliotecario
    public Bibliotecario saveBibliotecario(BibliotecarioDto bibliotecarioDto) {
        Bibliotecario bibliotecario = new Bibliotecario();
        bibliotecario.setNome(bibliotecarioDto.getNome());
        bibliotecario.setCpf(bibliotecarioDto.getCpf());
        bibliotecario.setEmail(bibliotecarioDto.getEmail());
        bibliotecario.setTelefone(bibliotecario.getTelefone());
        return bibliotecarioRepository.save(bibliotecario);
    }

    // editar um Bibliotecario
    public BibliotecarioDto editBibliotecario(Long id, BibliotecarioDto bibliotecarioDto) {
        Bibliotecario bibliotecario = bibliotecarioRepository.findById(id).orElseThrow();
        bibliotecario.setNome(bibliotecarioDto.getNome());
        bibliotecario.setCpf(bibliotecarioDto.getCpf());
        bibliotecario.setEmail(bibliotecarioDto.getEmail());
        bibliotecario.setTelefone(bibliotecario.getTelefone());
        Bibliotecario bibliotecarioEdit = bibliotecarioRepository.save(bibliotecario);
        return new BibliotecarioDto()
                .builder()
                .nome(bibliotecario.getNome())
                .cpf(bibliotecario.getCpf())
                .email(bibliotecario.getEmail())
                .telefone(bibliotecario.getTelefone())
                .build();
    }

    // apagar um bibliotecario
    public boolean deleteBibliotecario(Long id) {
        try {
            Bibliotecario bibliotecario = bibliotecarioRepository.findById(id).orElseThrow();
            bibliotecarioRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
