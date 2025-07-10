package br.com.biblioteca.usuario;

import br.com.biblioteca.usuario.mapper.UsuarioMapper;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
@Transactional
public class UsuarioService {

    @Inject
    UsuarioMapper usuarioMapper;

    @Inject
    UsuarioUpdateConverter usuarioUpdateConverter;

    public UsuarioDTO cadastrarUsuario(UsuarioDTO usuarioDTO) {
        Usuario usuario = usuarioMapper.toUsuario(usuarioDTO);
        usuario.persist();

        return usuarioMapper.toUsuarioDTO(usuario);
    }

    public UsuarioDTO atualizarUsuario(UsuarioDTO usuarioDTO) {
        Usuario usuario = Usuario.findById(usuarioDTO.getIdUsuario());
        usuarioUpdateConverter.usuarioConverterUpdate(usuarioDTO, usuario);
        usuario.persist();

        return usuarioMapper.toUsuarioDTO(usuario);
    }

    public UsuarioDTO buscarUsuarioPorId(Integer idUsuario) {
        Usuario usuario = Usuario.findById(idUsuario);
        return usuarioMapper.toUsuarioDTO(usuario);
    }
}
