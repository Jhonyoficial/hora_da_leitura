package br.com.biblioteca.emprestimo;

import br.com.biblioteca.emprestimo.dto.EmprestimoDTO;
import br.com.biblioteca.emprestimo.enumeration.EmprestimoStatus;
import br.com.biblioteca.emprestimo.mapper.EmprestimoMapper;
import br.com.biblioteca.livro.Livro;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.BadRequestException;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@ApplicationScoped
@Transactional
public class EmprestimoService extends EmprestimoValidator {

    @Inject
    EmprestimoMapper emprestimoMapper;

    public EmprestimoDTO emprestarLivro(EmprestimoDTO emprestimoDTO) {

        validarEmprestimoLivro(emprestimoDTO);
        var emprestimo = emprestimoMapper.toEmprestimo(emprestimoDTO);

        emprestimo.setDtEmprestimo(LocalDate.now());
        emprestimo.setFgStatus(EmprestimoStatus.EMPRESTADO);
        emprestimo.persist();

        Livro.update("nmDisponiveis = nmDisponiveis - 1 WHERE idLivro = ?1", emprestimo.getLivro().getIdLivro());

        return emprestimoMapper.toEmprestimoDTO(emprestimo);
    }

    public void devolverLivro(EmprestimoDTO emprestimoDTO) {

        Map<String, Object> params = new HashMap<>(Map.of(
                "idLivro", emprestimoDTO.getLivro().getIdLivro(),
                "idCliente", emprestimoDTO.getCliente().getIdCliente(),
                "fgStatus", List.of(EmprestimoStatus.PENDENTE, EmprestimoStatus.EMPRESTADO)
        ));

        Emprestimo emprestimo = Emprestimo.find("cliente.idCliente = :idCliente AND " +
                        "livro.idLivro = :idLivro AND fgStatus IN :fgStatus", params)
                .firstResult();

        if (emprestimo == null) {
            throw new BadRequestException("Emprestimo não encontrado");
        }

        emprestimo.setFgStatus(EmprestimoStatus.DEVOLVIDO);
        emprestimo.setDtDevolucao(LocalDate.now());
        emprestimo.persistAndFlush();

        Livro.update("nmDisponiveis = nmDisponiveis + 1 WHERE idLivro = ?1", emprestimo.getLivro().getIdLivro());

    }
}
