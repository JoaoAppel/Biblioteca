package br.edu.famper.biblioteca.controller;

import br.edu.famper.biblioteca.dto.BibliotecarioDto;
import br.edu.famper.biblioteca.exception.ResourceNotFoundException;
import br.edu.famper.biblioteca.model.Bibliotecario;
import br.edu.famper.biblioteca.service.BibliotecarioService;
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
@RequestMapping("/api/bibliotecario")
@RequiredArgsConstructor
@Slf4j
@Tag(name = "Bibliotecario",
        description = "Operation for cities")
public class BibliotecarioController {

    private final BibliotecarioService bibliotecarioService;

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
    public List<BibliotecarioDto> getAllBibliotecarios() {
        log.info("Buscando todas as bibliotecarios");
        return bibliotecarioService.getAllBibliotecarios();
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
    public ResponseEntity<BibliotecarioDto> getBibliotecarioById(@PathVariable(name = "id") Long id) throws ResourceNotFoundException {
        log.info("Buscando bibliotecario por id: {}", id);
        return ResponseEntity.ok().body(bibliotecarioService.getBibliotecarioById(id));
    }

    @PostMapping
    @Operation(summary = "Save city",
            description = "Save a city in database"
    )
    public Bibliotecario createBibliotecario(@RequestBody BibliotecarioDto bibliotecarioDto) throws ResourceNotFoundException {
        log.info("Cadastro bibliotecario: {}", bibliotecarioDto);
        return bibliotecarioService.saveBibliotecario(bibliotecarioDto);
    }

    @PatchMapping("/{id}")
    @Operation(summary = "Update city",
            description = "Update a city in database"
    )
    public ResponseEntity<BibliotecarioDto> updateBibliotecario(@PathVariable(name = "id") Long id, @RequestBody BibliotecarioDto bibliotecarioDto) throws ResourceNotFoundException {
        log.info("Atualizando bibliotecario: {}", bibliotecarioDto);
        return ResponseEntity.ok(bibliotecarioService.editBibliotecario(id, bibliotecarioDto));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Remove city",
            description = "Remove a city in database"
    )
    public Map<String, Boolean> deleteBibliotecario(@PathVariable(name = "id") Long id) throws Exception {
        log.info("Deletando bibliotecario: {}", id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", bibliotecarioService.deleteBibliotecario(id));
        return response;
    }
}
