package br.edu.famper.biblioteca.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AutorDto {
    @Schema(description = "Nome do autor",
            example = "Joao",
            title = "nome",
            maxLength = 150)
    private String nome;

    @Schema(description = "Nacionalidade do autor",
            example = "Brasil",
            title = "nacionalidade",
            maxLength = 50)
    private String nacionalidade;

    @Schema(description = "Data de nascimento do autor",
            example = "11/11/1978",
            title = "data_nascimento")
    private Date dataNascimento;
}
