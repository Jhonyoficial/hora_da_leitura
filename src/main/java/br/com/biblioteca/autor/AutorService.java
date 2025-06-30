package br.com.biblioteca.autor;

import br.com.biblioteca.autor.mapper.AutorMapper;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
@Transactional
public class AutorService {

    @Inject
    AutorMapper autorMapper;

    public AutorDTO cadastrarAutor(AutorDTO autorDTO) {
        Autor autor = autorMapper.toAutor(autorDTO);
        autor.persist();

        return autorMapper.toAutorDTO(autor);

    }
}
