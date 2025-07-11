package br.com.biblioteca.livro;

import br.com.biblioteca.livro.dto.LivroDTO;
import br.com.biblioteca.livro.dto.LivrosDisponiveisDTO;
import br.com.biblioteca.livro.mapper.LivroMapper;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
@Transactional
public class LivroService {

    @Inject
    LivroMapper livroMapper;

    @Inject
    LivroConverterUpdate livroConverterUpdate;

    public LivroDTO cadastrarLivro(LivroDTO livroDTO) {
        var livro = livroMapper.toLivro(livroDTO);
        livro.setNmDisponiveis(livroDTO.getNmExemplares());
        livro.persist();

        return livroMapper.toLivroDTO(livro);
    }

    public LivroDTO alterarLivro(LivroDTO livroDTO) {
        Livro livro = Livro.findById(livroDTO.getIdLivro());

        livroConverterUpdate.converterLivroUpdate(livroDTO, livro);
        livro.persist();

        return livroMapper.toLivroDTO(livro);
    }

    public LivroDTO buscarLivroPorId(Integer idlivro) {
        Livro livro = Livro.findById(idlivro);
        return livroMapper.toLivroDTO(livro);
    }

    public List<LivrosDisponiveisDTO> buscarLivrosDisponiveis(){
        List<LivrosDisponiveisDTO> livrosDisponiveis = Livro.find("nmDisponiveis > 0")
                .project(LivrosDisponiveisDTO.class)
                .list();


        return livrosDisponiveis;
    }
}
