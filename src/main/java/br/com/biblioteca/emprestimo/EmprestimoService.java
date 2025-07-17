package br.com.biblioteca.emprestimo;

import br.com.biblioteca.emprestimo.dto.EmprestimoDTO;
import br.com.biblioteca.emprestimo.dto.EmprestimoFiltroDTO;
import br.com.biblioteca.emprestimo.enumeration.EmprestimoStatus;
import br.com.biblioteca.emprestimo.mapper.EmprestimoMapper;
import br.com.biblioteca.emprestimo.orm.Emprestimo;
import br.com.biblioteca.livro.Livro;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import io.quarkus.hibernate.orm.panache.PanacheQuery;
import io.quarkus.panache.common.Page;
import io.quarkus.panache.common.Sort;
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

        if (emprestimo.getFgStatus().equals(EmprestimoStatus.CANCELADO) || emprestimo.getFgStatus().equals(EmprestimoStatus.DEVOLVIDO)) {
            Livro.update("nmDisponiveis = nmDisponiveis + 1 WHERE idLivro = ?1", emprestimo.getLivro().getIdLivro());
        }

    }

    public List<EmprestimoDTO> listarEmprestimoCliente(EmprestimoFiltroDTO filtro) {

        String query = "";
        Map<String, Object> params = new HashMap<>();

        if (filtro.getIdCliente() != null) {
            query += "cliente.idCliente = :idCliente AND ";
            params.put("idCliente", filtro.getIdCliente());
        }
        if (filtro.getIdEmprestimo() != null) {
            query += "idEmprestimo = :idEmprestimo AND ";
            params.put("idEmprestimo", filtro.getIdEmprestimo());
        }
        if (filtro.getIdLivro() != null) {
            query += "livro.idLivro = :idLivro AND ";
            params.put("idLivro", filtro.getIdLivro());
        }
        if (filtro.getFgStatus() != null) {
            query += "fgStatus = :fgStatus AND ";
            params.put("fgStatus", EmprestimoStatus.values()[filtro.getFgStatus()]);
        }

        if (!query.isEmpty()) {
            query = query.substring(0, query.length() - 5);
        }

        PanacheQuery<PanacheEntityBase> panacheEmprestimos = Emprestimo.find(query, Sort.by("fgStatus"), params);

        panacheEmprestimos.page()

        return emprestimoMapper.toEmprestimoDTO(emprestimos);
    }


}
