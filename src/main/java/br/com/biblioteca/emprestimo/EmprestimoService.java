package br.com.biblioteca.emprestimo;

import br.com.biblioteca.cliente.Cliente;
import br.com.biblioteca.emprestimo.dto.EmprestimoDTO;
import br.com.biblioteca.emprestimo.enumeration.EmprestimoStatus;
import br.com.biblioteca.emprestimo.mapper.EmprestimoMapper;
import br.com.biblioteca.livro.Livro;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.BadRequestException;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ApplicationScoped
@Transactional
public class EmprestimoService extends EmprestimoValidator {

    @Inject
    EmprestimoMapper emprestimoMapper;

    @Inject
    EmprestimoConverterUpdate converterUpdateEmprestimoUpdate;

    public EmprestimoDTO emprestarLivro(EmprestimoDTO emprestimoDTO) {

        validarEmprestimoLivro(emprestimoDTO);
        var emprestimo = emprestimoMapper.toEmprestimo(emprestimoDTO);

        emprestimo.setDtEmprestimo(LocalDate.now());
        emprestimo.setFgStatus(EmprestimoStatus.EMPRESTADO);
        emprestimo.persist();

        Livro.update("nmDisponiveis = nmDisponiveis - 1 WHERE idLivro = ?1", emprestimo.getLivro().getIdLivro());
        return emprestimoMapper.toEmprestimoDTO(emprestimo);
    }

    public void atualizarEmprestimo(EmprestimoDTO emprestimoDTO) {

        Emprestimo emprestimo = Emprestimo.findById(emprestimoDTO.getIdEmprestimo());

        if (emprestimo == null) {
            throw new BadRequestException("Emprestimo não encontrado");
        }

        converterUpdateEmprestimoUpdate.converterUpdateEmprestimo(emprestimoDTO, emprestimo);
        emprestimo.persist();

        Livro.update("nmDisponiveis = nmDisponiveis + 1 WHERE idLivro = ?1", emprestimo.getLivro().getIdLivro());

    }
}
