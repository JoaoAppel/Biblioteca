package br.edu.famper.biblioteca.service;

import br.edu.famper.biblioteca.dto.EmprestimoDto;
import br.edu.famper.biblioteca.model.Emprestimo;
import br.edu.famper.biblioteca.repository.EmprestimoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class EmprestimoService {

    // buscar um emprestimo

    @Autowired
    private EmprestimoRepository emprestimoRepository;

    public List<EmprestimoDto> getAllEmprestimos() {
        return emprestimoRepository
                .findAll()
                .stream()
                .map(emprestimo -> EmprestimoDto
                        .builder()
                        .dataEmprestimo(emprestimo.getDataEmprestimo())
                        .datadevolucao(emprestimo.getDatadevolucao())
                        .status(emprestimo.getStatus())
                        .build()
                )
                .toList();
    }

    public EmprestimoDto getEmprestimoById(Long id) {
        Emprestimo emprestimo = emprestimoRepository.findById(id).orElseThrow();
        return new EmprestimoDto()
                .builder()
                .dataEmprestimo(emprestimo.getDataEmprestimo())
                .datadevolucao(emprestimo.getDatadevolucao())
                .status(emprestimo.getStatus())
                .build();
    }

    // inserir um Emprestimo
    public Emprestimo saveEmprestimo(EmprestimoDto emprestimoDto) {
        Emprestimo emprestimo = new Emprestimo();
        emprestimo.setDataEmprestimo(emprestimoDto.getDataEmprestimo());
        emprestimo.setDatadevolucao(emprestimoDto.getDatadevolucao());
        emprestimo.setStatus(emprestimoDto.getStatus());
        return emprestimoRepository.save(emprestimo);
    }

    // editar um Emprestimo
    public EmprestimoDto editEmprestimo(Long id, EmprestimoDto emprestimoDto) {
        Emprestimo emprestimo = emprestimoRepository.findById(id).orElseThrow();
        emprestimo.setDataEmprestimo(emprestimoDto.getDataEmprestimo());
        emprestimo.setDatadevolucao(emprestimoDto.getDatadevolucao());
        emprestimo.setStatus(emprestimoDto.getStatus());
        Emprestimo emprestimoEdit = emprestimoRepository.save(emprestimo);
        return new EmprestimoDto()
                .builder()
                .dataEmprestimo(emprestimo.getDataEmprestimo())
                .datadevolucao(emprestimo.getDatadevolucao())
                .status(emprestimo.getStatus())
                .build();
    }

    // apagar um emprestimo
    public boolean deleteEmprestimo(Long id) {
        try {
            Emprestimo emprestimo = emprestimoRepository.findById(id).orElseThrow();
            emprestimoRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
