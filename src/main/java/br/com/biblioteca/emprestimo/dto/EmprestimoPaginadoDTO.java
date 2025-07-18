package br.com.biblioteca.emprestimo.dto;

import io.quarkus.hibernate.orm.panache.common.ProjectedFieldName;

import java.time.LocalDate;

public record EmprestimoPaginadoDTO(Integer idEmprestimo, @ProjectedFieldName("livro.dsTitulo") String dsTitulo, LocalDate dtLimiteDevolucao) {
}
