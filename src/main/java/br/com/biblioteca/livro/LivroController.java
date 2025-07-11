package br.com.biblioteca.livro;

import br.com.biblioteca.livro.dto.LivroDTO;
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
        var livro = livroService.buscarLivroPorId(idLivro);
        return Response.ok().entity(livro).build();
    }

    @GET
    @Path("disponiveis")
    public Response buscarLivrosDisponiveis(){
        var response = livroService.buscarLivrosDisponiveis();
        return Response.ok().entity(response).build();
    }
}
