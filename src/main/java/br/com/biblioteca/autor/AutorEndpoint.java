package br.com.biblioteca.autor;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Produces(value = MediaType.APPLICATION_JSON)
@Consumes(value = MediaType.APPLICATION_JSON)
@Path("autor")
public class AutorEndpoint {

    @Inject
    AutorService autorService;

    @POST
    public Response cadastrarAutor(AutorDTO autorDTO) {
        var response = autorService.cadastrarAutor(autorDTO);
        return Response.ok(response).build();
    }
}
