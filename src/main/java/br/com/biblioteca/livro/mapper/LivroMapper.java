package br.com.biblioteca.livro.mapper;

import br.com.biblioteca.livro.Livro;
import br.com.biblioteca.livro.LivroDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "jakarta-cdi")
public interface LivroMapper {
    LivroMapper INSTANCE = Mappers.getMapper(LivroMapper.class);

    public LivroDTO toLivroDTO(Livro livro);
    public Livro toLivro(LivroDTO livroDTO);
}
