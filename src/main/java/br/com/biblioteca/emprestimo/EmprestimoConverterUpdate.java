package br.com.biblioteca.emprestimo;

import br.com.biblioteca.emprestimo.dto.EmprestimoDTO;
import br.com.biblioteca.emprestimo.enumeration.EmprestimoStatus;
import br.com.biblioteca.emprestimo.orm.Emprestimo;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class EmprestimoConverterUpdate {

    public void converterUpdateEmprestimo(EmprestimoDTO emprestimoDTO, Emprestimo emprestimo) {
        emprestimo.setIdEmprestimo(emprestimoDTO.getIdEmprestimo());
        emprestimo.setDtLimiteDevolucao(emprestimoDTO.getDtLimiteDevolucao());
        emprestimo.setDtEmprestimo(emprestimoDTO.getDtEmprestimo());
        emprestimo.setDtDevolucao(emprestimoDTO.getDtDevolucao());
        emprestimo.setFgStatus(EmprestimoStatus.values()[emprestimoDTO.getFgStatus()]);

    }
}
