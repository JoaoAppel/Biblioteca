package br.edu.famper.biblioteca.controller;

import br.edu.famper.biblioteca.dto.LivroDto;
import br.edu.famper.biblioteca.exception.ResourceNotFoundException;
import br.edu.famper.biblioteca.model.Livro;
import br.edu.famper.biblioteca.service.LivroService;
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
@RequestMapping("/api/livro")
@RequiredArgsConstructor
@Slf4j
@Tag(name = "Livro",
        description = "Operation for cities")
public class LivroController {

    private final LivroService livroService;

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
    public List<LivroDto> getAllLivros() {
        log.info("Buscando todas as livros");
        return livroService.getAllLivros();
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
    public ResponseEntity<LivroDto> getLivroById(@PathVariable(name = "id") Long id) throws ResourceNotFoundException {
        log.info("Buscando livro por id: {}", id);
        return ResponseEntity.ok().body(livroService.getLivroById(id));
    }

    @PostMapping
    @Operation(summary = "Save city",
            description = "Save a city in database"
    )
    public Livro createLivro(@RequestBody LivroDto livroDto) throws ResourceNotFoundException {
        log.info("Cadastro livro: {}", livroDto);
        return livroService.saveLivro(livroDto);
    }

    @PatchMapping("/{id}")
    @Operation(summary = "Update city",
            description = "Update a city in database"
    )
    public ResponseEntity<LivroDto> updateLivro(@PathVariable(name = "id") Long id, @RequestBody LivroDto livroDto) throws ResourceNotFoundException {
        log.info("Atualizando livro: {}", livroDto);
        return ResponseEntity.ok(livroService.editLivro(id, livroDto));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Remove city",
            description = "Remove a city in database"
    )
    public Map<String, Boolean> deleteLivro(@PathVariable(name = "id") Long id) throws Exception {
        log.info("Deletando livro: {}", id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", livroService.deleteLivro(id));
        return response;
    }
}
