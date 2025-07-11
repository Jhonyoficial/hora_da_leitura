package br.com.biblioteca.livro;
import br.com.biblioteca.livro.dto.LivroDTO;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class LivroConverterUpdate {

    public void converterLivroUpdate(LivroDTO livroDTO, Livro livro) {

        livro.setNmAno(livroDTO.getNmAno());
        livro.setNmExemplares(livroDTO.getNmExemplares());
        livro.setDsTitulo(livroDTO.getDsTitulo());
        livro.setDsIsbn(livroDTO.getDsIsbn());
        livro.setDsNomeAutor(livro.getDsNomeAutor());

    }

}
