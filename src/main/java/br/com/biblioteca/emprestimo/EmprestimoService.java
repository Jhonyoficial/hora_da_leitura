package br.com.biblioteca.emprestimo;

import br.com.biblioteca.emprestimo.dto.EmprestimoDTO;
import br.com.biblioteca.emprestimo.mapper.EmprestimoMapper;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
@Transactional
public class EmprestimoService {

    @Inject
    EmprestimoMapper emprestimoMapper;

    public void emprestarLivro(EmprestimoDTO emprestimoDTO) {
        var emprestimo = emprestimoMapper.toEmprestimo(emprestimoDTO);
        System.out.println(emprestimo);


    }
}
