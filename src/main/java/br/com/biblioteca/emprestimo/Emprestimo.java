package br.com.biblioteca.emprestimo;

import br.com.biblioteca.cliente.Cliente;
import br.com.biblioteca.emprestimo.enumeration.EmprestimoStatus;
import br.com.biblioteca.livro.Livro;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "emprestimo")
@EqualsAndHashCode(callSuper = false)
public class Emprestimo extends PanacheEntityBase implements Serializable {

    @Column(name = "dt_emprestimo")
    private LocalDate dtEmprestimo;

    @Column(name = "dt_limite_devolucao")
    private LocalDate dtLimiteDevolucao;

    @Column(name = "dt_devolucao")
    private LocalDate dtDevolucao;

    @Id
    @Enumerated(EnumType.ORDINAL)
    @Column(name = "fg_status")
    private EmprestimoStatus fgStatus;

    @Id
    @JoinColumn(name = "id_cliente")
    @ManyToOne
    private Cliente cliente;

    @Id
    @JoinColumn(name = "id_livro")
    @ManyToOne
    private Livro livro;

}

