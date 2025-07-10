package br.com.biblioteca.livro;

import br.com.biblioteca.autor.mapper.AutorMapper;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class LivroConverterUpdate {

    @Inject
    AutorMapper autorMapper;

    public void converterLivroUpdate(LivroDTO livroDTO, Livro livro) {

        livro.setNmAno(livroDTO.getNmAno());
        livro.setNmExemplares(livroDTO.getNmExemplares());
        livro.setDsTitulo(livroDTO.getDsTitulo());
        livro.setDsIsbn(livroDTO.getDsIsbn());
        livro.setAutor(autorMapper.toAutor(livroDTO.getAutorDTO()));

    }

}
