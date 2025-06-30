package br.com.biblioteca.autor.mapper;

import br.com.biblioteca.autor.Autor;
import br.com.biblioteca.autor.AutorDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "jakarta-cdi")
public interface AutorMapper {
    AutorMapper mapper = Mappers.getMapper(AutorMapper.class);

    AutorDTO toAutorDTO(Autor autor);
    Autor toAutor(AutorDTO autorDTO);
}
