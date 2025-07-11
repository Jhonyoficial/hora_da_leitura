package br.com.biblioteca.livro.dto;

import io.quarkus.runtime.annotations.RegisterForReflection;

@RegisterForReflection
public record LivrosDisponiveisDTO(Integer idLivro, String dsTitulo, Integer nmDisponiveis) {
}
