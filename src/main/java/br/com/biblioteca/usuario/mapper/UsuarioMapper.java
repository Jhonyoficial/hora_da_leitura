package br.com.biblioteca.usuario.mapper;

import br.com.biblioteca.usuario.Usuario;
import br.com.biblioteca.usuario.UsuarioDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "jakarta-cdi")
public interface UsuarioMapper {

    UsuarioMapper mapper = Mappers.getMapper(UsuarioMapper.class);

    UsuarioDTO toUsuarioDTO(Usuario usuario);
    Usuario toUsuario(UsuarioDTO usuarioDTO);

}
