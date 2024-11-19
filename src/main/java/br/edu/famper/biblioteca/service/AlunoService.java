package br.edu.famper.biblioteca.service;

import br.edu.famper.biblioteca.dto.AlunoDto;
import br.edu.famper.biblioteca.model.Aluno;
import br.edu.famper.biblioteca.repository.AlunoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class AlunoService {

    // buscar um aluno

    @Autowired
    private AlunoRepository alunoRepository;

    public List<AlunoDto> getAllAlunos(){
        return alunoRepository
                .findAll()
                .stream()
                .map(aluno -> AlunoDto
                        .builder()
                        .nome(aluno.getNome())
                        .anoNascimento(aluno.getAnoNascimento())
                        .status(aluno.getStatus())
                        .build()
                )
                .toList();
    }
    public AlunoDto getAlunoById(Long id){
        Aluno aluno = alunoRepository.findById(id).orElseThrow();
        return new AlunoDto()
                .builder()
                .nome(aluno.getNome())
                .anoNascimento(aluno.getAnoNascimento())
                .status(aluno.getStatus())
                .build();
    }

    // inserir um Aluno
    public Aluno saveAluno(AlunoDto alunoDto){
        Aluno aluno = new Aluno();
        aluno.setNome(alunoDto.getNome());
        aluno.setAnoNascimento(alunoDto.getAnoNascimento());
        aluno.setStatus(alunoDto.getStatus());
        return alunoRepository.save(aluno);
    }

    // editar um Aluno
    public AlunoDto editAluno(Long id, AlunoDto alunoDto){
        Aluno aluno = alunoRepository.findById(id).orElseThrow();
        aluno.setNome(alunoDto.getNome());
        aluno.setAnoNascimento(alunoDto.getAnoNascimento());
        aluno.setStatus(alunoDto.getStatus());
        Aluno alunoEdit = alunoRepository.save(aluno);
        return new AlunoDto()
                .builder()
                .nome(aluno.getNome())
                .anoNascimento(aluno.getAnoNascimento())
                .status(aluno.getStatus())
                .build();
    }

    // apagar um aluno
    public boolean deleteAluno(Long id){
        try{
            Aluno aluno = alunoRepository.findById(id).orElseThrow();
            alunoRepository.deleteById(id);
            return true;
        } catch (Exception e){
            return false;
        }
    }


}
