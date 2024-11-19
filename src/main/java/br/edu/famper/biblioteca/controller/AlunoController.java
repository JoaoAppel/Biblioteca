package br.edu.famper.biblioteca.controller;

import br.edu.famper.biblioteca.dto.AlunoDto;
import br.edu.famper.biblioteca.exception.ResourceNotFoundException;
import br.edu.famper.biblioteca.model.Aluno;
import br.edu.famper.biblioteca.service.AlunoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/aluno")
@RequiredArgsConstructor
@Slf4j
@Tag(name = "Aluno",
        description = "Operation for cities")
public class AlunoController {

    private final AlunoService alunoService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get all cities from DB",
            description = "Fetches all cities from DB and return " +
                    "in JSON Array"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful"),
            @ApiResponse(responseCode = "404", description = "not fund")
    })
    public List<AlunoDto> getAllAlunos() {
        log.info("Buscando todas as alunos");
        return alunoService.getAllAlunos();
    }


    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get one city from DB",
            description = "Fetches one city from DB and return " +
                    "in JSON Object"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful"),
            @ApiResponse(responseCode = "404", description = "not fund")
    })
    public ResponseEntity<AlunoDto> getAlunoById(@PathVariable(name = "id") Long id) throws ResourceNotFoundException {
        log.info("Buscando aluno por id: {}", id);
        return ResponseEntity.ok().body(alunoService.getAlunoById(id));
    }

    @PostMapping
    @Operation(summary = "Save city",
            description = "Save a city in database"
    )
    public Aluno createAluno(@RequestBody AlunoDto alunoDto) throws ResourceNotFoundException {
        log.info("Cadastro aluno: {}", alunoDto);
        return alunoService.saveAluno(alunoDto);
    }

    @PatchMapping("/{id}")
    @Operation(summary = "Update city",
            description = "Update a city in database"
    )
    public ResponseEntity<AlunoDto> updateAluno(@PathVariable(name = "id") Long id, @RequestBody AlunoDto alunoDto) throws ResourceNotFoundException {
        log.info("Atualizando aluno: {}", alunoDto);
        return ResponseEntity.ok(alunoService.editAluno(id, alunoDto));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Remove city",
            description = "Remove a city in database"
    )
    public Map<String, Boolean> deleteAluno(@PathVariable(name = "id") Long id) throws Exception {
        log.info("Deletando aluno: {}", id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", alunoService.deleteAluno(id));
        return response;
    }
}
