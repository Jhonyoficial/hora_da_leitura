package br.com.biblioteca.livro;

import br.com.biblioteca.autor.AutorDTO;
import lombok.Data;

@Data
public class LivroDTO {

    private Integer idLivro;

    private Integer nmAno;

    private Integer nmExemplares;

    private String dsTitulo;

    private String dsIsbn;

    private AutorDTO autorDTO;
}
