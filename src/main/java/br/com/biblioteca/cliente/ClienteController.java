package br.com.biblioteca.cliente;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Produces(value = MediaType.APPLICATION_JSON)
@Consumes(value = MediaType.APPLICATION_JSON)
@Path("cliente")
public class ClienteController {

    @Inject
    ClienteService autorService;

    @POST
    public Response cadastrarAutor(ClienteDTO clienteDTO) {
        var response = autorService.cadastrarCliente(clienteDTO);
        return Response.ok(response).build();
    }

    @PUT
    public Response alterarAutor(ClienteDTO clienteDTO) {
        var response = autorService.atualizarCliente(clienteDTO);
        return Response.ok(response).build();
    }

    @GET
    @Path("{idAutor}")
    public Response buscarAutorPorId(@PathParam("idAutor") Integer idAutor) {
        var response = autorService.buscarClientePorId(idAutor);
        return Response.ok().entity(response).build();
    }
}
