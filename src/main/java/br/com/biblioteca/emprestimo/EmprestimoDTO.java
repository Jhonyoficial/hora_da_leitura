package br.com.biblioteca.emprestimo;

import br.com.biblioteca.livro.LivroDTO;
import br.com.biblioteca.usuario.UsuarioDTO;
import lombok.Data;

import java.time.LocalDate;

@Data
public class EmprestimoDTO {

    private Integer idEmprestimo;

    private LocalDate dtEmprestimo;

    private LocalDate dtDevolucao;

    private UsuarioDTO usuario;

    private LivroDTO livro;


}
