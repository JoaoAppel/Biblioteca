package br.edu.famper.biblioteca.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LivroDto {
    @Schema(description = "Titulo do livro",
            example = "Joao",
            title = "titulo",
            maxLength = 150)
    private String titulo;

    @Schema(description = "Ano de publicacao do livro",
            example = "11/11/1978",
            title = "ano_publicacao",
            maxLength = 4)
    private String anoPublicacao;
}
