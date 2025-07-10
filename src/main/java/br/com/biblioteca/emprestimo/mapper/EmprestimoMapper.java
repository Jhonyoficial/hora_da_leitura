package br.com.biblioteca.emprestimo.mapper;

import br.com.biblioteca.emprestimo.Emprestimo;
import br.com.biblioteca.emprestimo.dto.EmprestimoDTO;
import br.com.biblioteca.emprestimo.enumeration.EmprestimoStatus;
import org.mapstruct.EnumMapping;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "jakarta-cdi")
public interface EmprestimoMapper {
    EmprestimoMapper INSTANCE = Mappers.getMapper(EmprestimoMapper.class);

    EmprestimoDTO toEmprestimoDTO(Emprestimo emprestimo);
    Emprestimo toEmprestimo(EmprestimoDTO emprestimoDTO);

    @EnumMapping()
    default EmprestimoStatus map(Integer fgStatus) {
        return fgStatus != null ? EmprestimoStatus.values()[fgStatus] : null;
    }

    @EnumMapping()
    default Integer map(EmprestimoStatus fgStatus){
        return fgStatus != null ? fgStatus.ordinal() : null;
    }
}
