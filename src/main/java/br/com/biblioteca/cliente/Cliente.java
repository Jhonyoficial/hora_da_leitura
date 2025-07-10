package br.com.biblioteca.cliente;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Data
@Entity
@Table(name = "cliente")
@EqualsAndHashCode(callSuper = false)
@SequenceGenerator(name = "seq_cliente", sequenceName = "seq_cliente", allocationSize = 1)
public class Cliente extends PanacheEntityBase implements Serializable {

    @Id
    @GeneratedValue(generator = "seq_autor", strategy = GenerationType.SEQUENCE)
    @Column(name = "id_cliente")
    private Integer idCliente;

    @Column(name = "ds_nome")
    private String dsNome;
}
