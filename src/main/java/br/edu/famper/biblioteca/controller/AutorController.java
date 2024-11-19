package br.edu.famper.biblioteca.controller;

import br.edu.famper.biblioteca.dto.AutorDto;
import br.edu.famper.biblioteca.exception.ResourceNotFoundException;
import br.edu.famper.biblioteca.model.Autor;
import br.edu.famper.biblioteca.service.AutorService;
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
@RequestMapping("/api/autor")
@RequiredArgsConstructor
@Slf4j
@Tag(name = "Autor",
        description = "Operation for cities")
public class AutorController {

    private final AutorService autorService;

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
    public List<AutorDto> getAllAutors() {
        log.info("Buscando todas as autors");
        return autorService.getAllAutors();
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
    public ResponseEntity<AutorDto> getAutorById(@PathVariable(name = "id") Long id) throws ResourceNotFoundException {
        log.info("Buscando autor por id: {}", id);
        return ResponseEntity.ok().body(autorService.getAutorById(id));
    }

    @PostMapping
    @Operation(summary = "Save city",
            description = "Save a city in database"
    )
    public Autor createAutor(@RequestBody AutorDto autorDto) throws ResourceNotFoundException {
        log.info("Cadastro autor: {}", autorDto);
        return autorService.saveAutor(autorDto);
    }

    @PatchMapping("/{id}")
    @Operation(summary = "Update city",
            description = "Update a city in database"
    )
    public ResponseEntity<AutorDto> updateAutor(@PathVariable(name = "id") Long id, @RequestBody AutorDto autorDto) throws ResourceNotFoundException {
        log.info("Atualizando autor: {}", autorDto);
        return ResponseEntity.ok(autorService.editAutor(id, autorDto));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Remove city",
            description = "Remove a city in database"
    )
    public Map<String, Boolean> deleteAutor(@PathVariable(name = "id") Long id) throws Exception {
        log.info("Deletando autor: {}", id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", autorService.deleteAutor(id));
        return response;
    }
}
