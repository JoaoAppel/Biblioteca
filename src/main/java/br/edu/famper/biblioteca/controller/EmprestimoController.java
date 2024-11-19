package br.edu.famper.biblioteca.controller;

import br.edu.famper.biblioteca.dto.EmprestimoDto;
import br.edu.famper.biblioteca.exception.ResourceNotFoundException;
import br.edu.famper.biblioteca.model.Emprestimo;
import br.edu.famper.biblioteca.service.EmprestimoService;
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
@RequestMapping("/api/emprestimo")
@RequiredArgsConstructor
@Slf4j
@Tag(name = "Emprestimo",
        description = "Operation for cities")
public class EmprestimoController {

    private final EmprestimoService emprestimoService;

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
    public List<EmprestimoDto> getAllEmprestimos() {
        log.info("Buscando todas as emprestimos");
        return emprestimoService.getAllEmprestimos();
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
    public ResponseEntity<EmprestimoDto> getEmprestimoById(@PathVariable(name = "id") Long id) throws ResourceNotFoundException {
        log.info("Buscando emprestimo por id: {}", id);
        return ResponseEntity.ok().body(emprestimoService.getEmprestimoById(id));
    }

    @PostMapping
    @Operation(summary = "Save city",
            description = "Save a city in database"
    )
    public Emprestimo createEmprestimo(@RequestBody EmprestimoDto emprestimoDto) throws ResourceNotFoundException {
        log.info("Cadastro emprestimo: {}", emprestimoDto);
        return emprestimoService.saveEmprestimo(emprestimoDto);
    }

    @PatchMapping("/{id}")
    @Operation(summary = "Update city",
            description = "Update a city in database"
    )
    public ResponseEntity<EmprestimoDto> updateEmprestimo(@PathVariable(name = "id") Long id, @RequestBody EmprestimoDto emprestimoDto) throws ResourceNotFoundException {
        log.info("Atualizando emprestimo: {}", emprestimoDto);
        return ResponseEntity.ok(emprestimoService.editEmprestimo(id, emprestimoDto));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Remove city",
            description = "Remove a city in database"
    )
    public Map<String, Boolean> deleteEmprestimo(@PathVariable(name = "id") Long id) throws Exception {
        log.info("Deletando emprestimo: {}", id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", emprestimoService.deleteEmprestimo(id));
        return response;
    }
}
