import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.List;

@Transactional
@ApplicationScoped
public class ClienteService {

    @Inject
    ClienteRepository clienteRepository;

    // Buscar todos los clientes
    public List<ModelCliente> listarClientes() {
        return clienteRepository.listAll();
    }

    // Buscar cliente por ID
    public ModelCliente buscarId(Long id) {
        return clienteRepository.findById(id);
    }

    // Crear cliente
    public ModelCliente crearCliente(ModelCliente cliente) {
        clienteRepository.persist(cliente);
        return cliente;
    }

    // Eliminar cliente
    public void eliminarCliente(Long id) {
        clienteRepository.deleteById(id);
    }

    // Actualizar cliente
    public ModelCliente actualizarCliente(Long id, ModelCliente cliente) {
        ModelCliente clienteExistente = this.buscarId(id);
        if (clienteExistente != null) {
            clienteExistente.setNameC(cliente.getNameC());
            clienteExistente.setRucC(cliente.getRucC());
            clienteExistente.setEmailC(cliente.getEmailC());
            clienteExistente.setCelular(cliente.getCelular());
            clienteExistente.setDireccionC(cliente.getDireccionC());
            return clienteExistente; // no hace falta persist
        }
        return null;
    }

}
