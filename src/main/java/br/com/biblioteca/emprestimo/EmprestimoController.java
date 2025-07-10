package br.com.biblioteca.emprestimo;

import br.com.biblioteca.emprestimo.dto.EmprestimoDTO;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("emprestimo")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class EmprestimoController {

    @Inject
    EmprestimoService emprestimoService;

    @POST
    public Response gerarEmprestimo(EmprestimoDTO emprestimoDTO) {
        emprestimoService.emprestarLivro(emprestimoDTO);
        return Response.ok().build();
    }
}
