package br.edu.famper.biblioteca.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BibliotecarioDto {
    @Schema(description = "Nome do bibliotecario",
            example = "Joao",
            title = "nome",
            maxLength = 150)
    private String nome;

    @Schema(description = "Cpf do bibliotecario",
            example = "12345678912",
            title = "cpf",
            maxLength = 11)
    private String cpf;

    @Schema(description = "e-mail do bibliotecario",
            example = "exemplo123@gmail.com",
            title = "e-mail",
            maxLength = 150)
    private String email;

    @Schema(description = "Telefone do bibliotecario",
            example = "46999123456",
            title = "telefone",
            maxLength = 11)
    private String telefone;
}
