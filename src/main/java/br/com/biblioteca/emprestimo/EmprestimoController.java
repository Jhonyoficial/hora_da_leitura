package br.com.biblioteca.emprestimo;

import br.com.biblioteca.emprestimo.dto.EmprestimoDTO;
import br.com.biblioteca.emprestimo.dto.EmprestimoFiltroDTO;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
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
        final var response = emprestimoService.emprestarLivro(emprestimoDTO);
        return Response.ok().entity(response).build();
    }

    @PUT
    public Response devolverEmprestimo(EmprestimoDTO emprestimoDTO) {
        emprestimoService.atualizarEmprestimo(emprestimoDTO);
        return Response.ok().build();
    }

    @GET
    @Path("cliente")
    public Response listarEmprestimoCliente(EmprestimoFiltroDTO filtro) {
        var response = emprestimoService.listarEmprestimoCliente(filtro);
        return Response.ok().entity(response).build();
    }
}
