package br.com.biblioteca.autor;

import br.com.biblioteca.autor.mapper.AutorMapper;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class AutorService {

    @Inject
    AutorMapper autorMapper;

    public void cadastrarAutor(AutorDTO autorDTO) {
        Autor autor = autorMapper.toAutor(autorDTO);

    }
}
