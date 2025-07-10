package br.com.biblioteca.livro;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("livro")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class LivroController {

    @Inject
    LivroService livroService;

    @POST
    public Response cadastrarLivro(LivroDTO livroDTO) {
        var response = livroService.cadastrarLivro(livroDTO);
        return Response.ok().entity(response).build();
    }

    @GET
    public Response alterarLivro(LivroDTO livroDTO) {
        var response = livroService.alterarLivro(livroDTO);
        return Response.ok().entity(response).build();
    }

    @GET
    @Path("{idLivro}")
    public Response buscarLivroPorId(@PathParam("idLivro") Integer idLivro) {
        var livro = Livro.findById(idLivro);
        return Response.ok().entity(livro).build();
    }
}
