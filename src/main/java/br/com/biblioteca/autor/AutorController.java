package br.com.biblioteca.autor;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Produces(value = MediaType.APPLICATION_JSON)
@Consumes(value = MediaType.APPLICATION_JSON)
@Path("autor")
public class AutorController {

    @Inject
    AutorService autorService;

    @POST
    public Response cadastrarAutor(AutorDTO autorDTO) {
        var response = autorService.cadastrarAutor(autorDTO);
        return Response.ok(response).build();
    }

    @PUT
    public Response alterarAutor(AutorDTO autorDTO) {
        var response = autorService.atualizarAutor(autorDTO);
        return Response.ok(response).build();
    }

    @GET
    @Path("{idAutor}")
    public Response buscarAutorPorId(@PathParam("idAutor") Integer idAutor) {
        var response = autorService.buscarAutorPorId(idAutor);
        return Response.ok().entity(response).build();
    }
}
