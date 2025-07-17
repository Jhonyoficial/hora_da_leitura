package br.com.biblioteca.emprestimo.dto;

import jakarta.ws.rs.QueryParam;
import lombok.Data;

@Data
public class EmprestimoFiltroDTO {

    @QueryParam("idEmprestimo")
    private Integer idEmprestimo;

    @QueryParam("idCliente")
    private Integer idCliente;

    @QueryParam("fgStatus")
    private Integer fgStatus;

    @QueryParam("idLivro")
    private Integer idLivro;
}
