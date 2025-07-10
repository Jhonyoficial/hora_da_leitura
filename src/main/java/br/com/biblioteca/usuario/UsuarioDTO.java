package br.com.biblioteca.usuario;

import lombok.Data;

@Data
public class UsuarioDTO {

    private Integer idUsuario;

    private String dsNome;

    private String dsEmail;

    private String dsTelefone;
}
