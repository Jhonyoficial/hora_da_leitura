package br.com.biblioteca.livro;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@EqualsAndHashCode(callSuper = false)
@Data
@Entity
@Table(name = "livro")
@SequenceGenerator(name = "seq_livro", sequenceName = "seq_livro", allocationSize = 1)
public class Livro extends PanacheEntityBase implements Serializable {

    @Id
    @GeneratedValue(generator = "seq_livro", strategy = GenerationType.SEQUENCE)
    @Column(name = "id_livro")
    private Integer idLivro;

    @Column(name = "nm_ano")
    private Integer nmAno;

    @Column(name = "nm_exemplares")
    private Integer nmExemplares;

    @Column(name = "nm_disponiveis")
    private Integer nmDisponiveis;

    @Column(name = "ds_titulo")
    private String dsTitulo;

    @Column(name = "ds_isbn")
    private String dsIsbn;

    @Column(name = "ds_nome_autor")
    private String dsNomeAutor;
}
