package br.com.biblioteca.autor;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Data
@Entity
@Table(name = "autor")
@EqualsAndHashCode(callSuper = false)
@SequenceGenerator(name = "seq_autor", sequenceName = "seq_autor", allocationSize = 1)
public class Autor extends PanacheEntityBase implements Serializable {

    @Id
    @GeneratedValue(generator = "seq_autor", strategy = GenerationType.SEQUENCE)
    @Column(name = "id_autor")
    private Integer idAutor;

    @Column(name = "ds_nome_autor")
    private String dsNomeAutor;
}
