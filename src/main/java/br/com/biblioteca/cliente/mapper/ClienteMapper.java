package br.com.biblioteca.cliente.mapper;

import br.com.biblioteca.cliente.ClienteDTO;
import br.com.biblioteca.cliente.Cliente;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "jakarta-cdi")
public interface ClienteMapper {
    ClienteMapper mapper = Mappers.getMapper(ClienteMapper.class);

    ClienteDTO toAutorDTO(Cliente autor);
    Cliente toAutor(ClienteDTO clienteDTO);
}
