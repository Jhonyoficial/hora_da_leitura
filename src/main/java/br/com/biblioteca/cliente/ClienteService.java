package br.com.biblioteca.cliente;

import br.com.biblioteca.cliente.mapper.ClienteMapper;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
@Transactional
public class ClienteService {

    @Inject
    ClienteMapper clienteMapper;

    public ClienteDTO cadastrarCliente(ClienteDTO clienteDTO) {
        Cliente cliente = clienteMapper.toAutor(clienteDTO);
        cliente.persist();

        return clienteMapper.toAutorDTO(cliente);

    }

    public ClienteDTO atualizarCliente(ClienteDTO clienteDTO) {
        Cliente cliente = clienteMapper.toAutor(clienteDTO);
        cliente.persist();

        return clienteMapper.toAutorDTO(cliente);
    }

    public ClienteDTO buscarClientePorId(Integer idCliente) {
        Cliente cliente = Cliente.findById(idCliente);
        return clienteMapper.toAutorDTO(cliente);
    }
}
