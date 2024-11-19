package br.edu.famper.biblioteca.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AlunoDto {
    @Schema(description = "Nome do aluno",
            example = "Joao",
            title = "nome",
            maxLength = 150)
    private String nome;

    @Schema(description = "Ano de nascimento do aluno",
            example = "2004",
            title = "nome",
            maxLength = 4)
    private String anoNascimento;

    @Schema(description = "Status da matricula do aluno",
            example = "Ativo",
            title = "nome")
    private String status;

}
