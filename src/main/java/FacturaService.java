import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;

@ApplicationScoped
public class FacturaService {

    @Inject
    FacturaRepository facturaRepository;

    @Inject
    ClienteRepository clienteRepository;

    @Inject
    ProductoRepository productoRepository;

    // Listar todas las facturas
    public List<ModelFactura> listarFacturas() {
        return facturaRepository.listAll();
    }

    // Buscar factura por ID
    public ModelFactura buscarId(Long id) {
        return facturaRepository.findById(id);
    }

    public ModelFactura crearFactura(ModelFactura factura, Long clienteId, Long productoId) {
        // Buscar cliente
        ModelCliente cliente = clienteRepository.findById(clienteId);
        if (cliente == null) {
            throw new IllegalArgumentException("Cliente con ID " + clienteId + " no existe");
        }
        factura.setCliente(cliente);

        // Buscar producto
        ModelProducto producto = productoRepository.findById(productoId);
        if (producto == null) {
            throw new IllegalArgumentException("Producto con ID " + productoId + " no existe");
        }
        factura.setProducto(producto);

        // Guardar factura
        facturaRepository.persist(factura);
        return factura;
    }


    // Eliminar factura
    public void eliminarFactura(Long id) {
        facturaRepository.deleteById(id);
    }

    public ModelFactura actualizarFactura(Long id, ModelFactura facturaActualizada, Long clienteId, Long productoId) {
        // Buscar la factura existente
        ModelFactura facturaExistente = facturaRepository.findById(id);
        if (facturaExistente == null) {
            throw new IllegalArgumentException("Factura con ID " + id + " no existe");
        }

        // Actualizar total si se proporciona
        if (facturaActualizada.getTotalF() != null) {
            facturaExistente.setTotalF(facturaActualizada.getTotalF());
        }

        // Actualizar cliente si se proporciona un nuevo clienteId
        if (clienteId != null) {
            ModelCliente cliente = clienteRepository.findById(clienteId);
            if (cliente == null) {
                throw new IllegalArgumentException("Cliente con ID " + clienteId + " no existe");
            }
            facturaExistente.setCliente(cliente);
        }

        // Actualizar producto si se proporciona un nuevo productoId
        if (productoId != null) {
            ModelProducto producto = productoRepository.findById(productoId);
            if (producto == null) {
                throw new IllegalArgumentException("Producto con ID " + productoId + " no existe");
            }
            facturaExistente.setProducto(producto);
        }

        // Persistir cambios
        facturaRepository.persist(facturaExistente);

        return facturaExistente;
    }


}
