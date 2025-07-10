package br.com.biblioteca.usuario;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class UsuarioUpdateConverter {

    public void usuarioConverterUpdate(UsuarioDTO usuarioDTO, Usuario usuario) {
        usuario.setDsNome(usuarioDTO.getDsNome());
        usuario.setDsEmail(usuarioDTO.getDsEmail());
        usuario.setDsTelefone(usuarioDTO.getDsTelefone());
    }
}
