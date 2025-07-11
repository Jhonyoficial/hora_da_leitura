package br.com.biblioteca.livro.dto;

import lombok.Data;

@Data
public class LivroDTO {

    private Integer idLivro;

    private Integer nmAno;

    private Integer nmExemplares;

    private Integer nmDisponiveis;

    private String dsTitulo;

    private String dsIsbn;

    private String dsNomeAutor;
}
