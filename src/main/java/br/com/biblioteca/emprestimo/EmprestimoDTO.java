package br.com.biblioteca.emprestimo;

import br.com.biblioteca.cliente.ClienteDTO;
import br.com.biblioteca.livro.LivroDTO;
import lombok.Data;

import java.time.LocalDate;

@Data
public class EmprestimoDTO {

    private Integer idEmprestimo;

    private LocalDate dtEmprestimo;

    private LocalDate dtDevolucao;

    private ClienteDTO cliente;

    private LivroDTO livro;


}
