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
@SequenceGenerator(name = "seq_emprestimo", sequenceName = "seq_emprestimo",  allocationSize = 1)
public class Emprestimo extends PanacheEntityBase implements Serializable {

    @Id
    @GeneratedValue(generator = "seq_emprestimo", strategy = GenerationType.IDENTITY)
    @Column(name = "id_emprestimo")
    private Integer idEmprestimo;

    @Column(name = "dt_emprestimo")
    private LocalDate dtEmprestimo;

    @Column(name = "dt_limite_devolucao")
    private LocalDate dtLimiteDevolucao;

    @Column(name = "dt_devolucao")
    private LocalDate dtDevolucao;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "fg_status")
    private EmprestimoStatus fgStatus;

    @JoinColumn(name = "id_cliente")
    @ManyToOne
    private Cliente cliente;

    @JoinColumn(name = "id_livro")
    @ManyToOne
    private Livro livro;

}

