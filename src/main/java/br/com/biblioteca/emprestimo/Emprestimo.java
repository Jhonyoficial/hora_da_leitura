package br.com.biblioteca.emprestimo;

import br.com.biblioteca.livro.Livro;
import br.com.biblioteca.usuario.Usuario;
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
    @Column(name = "id_emprestimo")
    @GeneratedValue(generator = "seq_emprestimo",  strategy = GenerationType.SEQUENCE)
    private Integer idEmprestimo;

    @Column(name = "dt_emprestimo")
    private LocalDate dtEmprestimo;

    @Column(name = "dt_devolucao")
    private LocalDate dtDevolucao;

    @JoinColumn(name = "id_usuario")
    @ManyToOne
    private Usuario usuario;

    @JoinColumn(name = "id_livro")
    @ManyToOne
    private Livro livro;

}

