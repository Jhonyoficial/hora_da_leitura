package br.com.biblioteca.livro.mapper;

import br.com.biblioteca.livro.Livro;
import br.com.biblioteca.livro.dto.LivroDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "jakarta-cdi")
public interface LivroMapper {
    LivroMapper INSTANCE = Mappers.getMapper(LivroMapper.class);

     LivroDTO toLivroDTO(Livro livro);
     Livro toLivro(LivroDTO livroDTO);
}
