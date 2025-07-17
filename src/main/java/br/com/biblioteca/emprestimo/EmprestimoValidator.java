package br.com.biblioteca.emprestimo;

import br.com.biblioteca.emprestimo.dto.EmprestimoDTO;
import br.com.biblioteca.emprestimo.enumeration.EmprestimoStatus;
import br.com.biblioteca.emprestimo.orm.Emprestimo;
import br.com.biblioteca.livro.Livro;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.BadRequestException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ApplicationScoped
public class EmprestimoValidator {

    public void validarEmprestimoLivro(EmprestimoDTO emprestimoDTO) {

        long count = Livro.find("nmDisponiveis > 0 AND idLivro = ?1", emprestimoDTO.getLivro().getIdLivro()).count();
        if (count == 0) {
            throw new BadRequestException("Livro não está disponível para emprestimo");
        }

        boolean isPresent = Emprestimo.find("cliente.idCliente = ?1 and livro.idLivro = ?2",
                        emprestimoDTO.getCliente().getIdCliente(), emprestimoDTO.getLivro().getIdLivro())
                .firstResultOptional()
                .isPresent();

        if (isPresent) {
            throw new BadRequestException("Livro já esta emprestado para esse cliente");
        }

        Map<String, Object> params = new HashMap<>(Map.of(
                "idCliente", emprestimoDTO.getCliente().getIdCliente(),
                "fgStatus", List.of(EmprestimoStatus.PENDENTE, EmprestimoStatus.EMPRESTADO)
        ));

        List<Emprestimo> listaDeEmprestimo = Emprestimo.find(
                "cliente.idCliente = :idCliente AND fgStatus IN (:fgStatus)", params
        ).list();

        if (listaDeEmprestimo.size() >= 3) {
            throw new BadRequestException("Cliente já possui 3 livros emprestados");
        }
    }
}
