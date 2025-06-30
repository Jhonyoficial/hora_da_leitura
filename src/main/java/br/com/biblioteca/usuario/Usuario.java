package br.com.biblioteca.usuario;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Data
@Entity
@Table(name = "usuario")
@EqualsAndHashCode(callSuper = false)
@SequenceGenerator(name = "seq_usuario", sequenceName = "seq_usuario", allocationSize = 1)
public class Usuario extends PanacheEntityBase implements Serializable {

    @Id
    @GeneratedValue(generator = "seq_usuario", strategy = GenerationType.SEQUENCE)
    @Column(name = "id_usuario")
    private Integer idUsuario;

    @Column(name = "ds_nome")
    private String dsNome;

    @Column(name = "ds_email")
    private String dsEmail;

    @Column(name = "ds_telefone")
    private String dsTelefone;

}
