package br.com.biblioteca.usuario;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("usuario")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UsuarioController {

    @Inject
    UsuarioService usuarioService;

    @POST
    public Response cadastrarUsuario(UsuarioDTO usuarioDTO) {
        var response = usuarioService.cadastrarUsuario(usuarioDTO);
        return Response.ok(response).build();
    }

    @PUT
    public Response atualizarUsuario(UsuarioDTO usuarioDTO) {
        var response = usuarioService.atualizarUsuario(usuarioDTO);
        return Response.ok().entity(response).build();
    }

    @GET
    @Path("{idUsuario}")
    public Response buscarUsuarioPorId(@PathParam("idUsuario") Integer idUsuario) {
        var response = usuarioService.buscarUsuarioPorId(idUsuario);
        return Response.ok().entity(response).build();
    }

}
