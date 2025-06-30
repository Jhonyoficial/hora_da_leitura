package br.com.biblioteca.livro;

import br.com.biblioteca.autor.Autor;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@EqualsAndHashCode(callSuper = false)
@Data
@Entity
@Table(name = "livro")
@SequenceGenerator(name = "seq_livro", sequenceName = "seq_livro" , allocationSize = 1)
public class Livro extends PanacheEntityBase implements Serializable {

    @Id
    @GeneratedValue(generator = "seq_livro", strategy = GenerationType.SEQUENCE)
    @Column(name = "id_livro")
    private Integer idLivro;

    @Column(name = "nm_ano")
    private Integer nmAno;

    @Column(name = "ds_titulo")
    private String dsTitulo;

    @Column(name = "ds_isbn")
    private String dsIsbn;

    @Column(name = "nm_exemplares")
    private String nmExemplares;

    @JoinColumn(name = "id_autor", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private Autor autor;
}
