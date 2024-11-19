package br.edu.famper.biblioteca.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmprestimoDto {
    @Schema(description = "Data de emprestimo",
            example = "06/11/2024",
            title = "data_emprestimo")
    private Date dataEmprestimo;

    @Schema(description = "Data de devolucao",
            example = "15/11/2024",
            title = "data_devolucao")
    private Date datadevolucao;

    @Schema(description = "Status do bibliotecario",
            example = "Joao",
            title = "status",
            maxLength = 25)
    private String status;
}
