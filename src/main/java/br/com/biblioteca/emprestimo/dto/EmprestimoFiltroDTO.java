package br.com.biblioteca.emprestimo.dto;

import br.com.biblioteca.generic.PaginacaoDTO;
import jakarta.ws.rs.QueryParam;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = false)
@Data
public class EmprestimoFiltroDTO extends PaginacaoDTO {

    @QueryParam("idEmprestimo")
    private Integer idEmprestimo;

    @QueryParam("idCliente")
    private Integer idCliente;

    @QueryParam("fgStatus")
    private Integer fgStatus;

    @QueryParam("idLivro")
    private Integer idLivro;
}
