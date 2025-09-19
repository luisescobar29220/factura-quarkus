import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
@Transactional
public class ProductoService {

    @Inject
    ProductoRepository productoRepository;

    // Buscar todos los productos
    public List<ModelProducto> listarProductos() {
        return productoRepository.listAll();
    }

    // Buscar producto por ID
    public ModelProducto buscarId(Long id) {
        return productoRepository.findById(id);
    }

    // Crear producto
    public ModelProducto crearProducto(ModelProducto producto) {
        productoRepository.persist(producto);
        return producto;
    }

    // Eliminar producto
    public void eliminarProducto(Long id) {
        productoRepository.deleteById(id);
    }

    // Actualizar producto
    public ModelProducto actualizarProducto(Long id, ModelProducto producto) {
        ModelProducto productoExistente = this.buscarId(id);
        if (productoExistente != null) {
            // Actualiza los campos que quieras
            productoExistente.setNombreP(producto.getNombreP());
            productoExistente.setPrecioP(producto.getPrecioP());

            productoRepository.persist(productoExistente);
            return productoExistente;
        }
        return null;
    }
}
