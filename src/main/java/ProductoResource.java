import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/producto")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProductoResource {

    @Inject
    ProductoService productoService;

    // Listar productos
    @GET
    public List<ModelProducto> listarProductos() {
        return productoService.listarProductos();
    }

    // Buscar producto por ID
    @GET
    @Path("/{id}")
    public Response buscarProducto(@PathParam("id") Long id) {
        ModelProducto producto = productoService.buscarId(id);
        if (producto != null) {
            return Response.ok(producto).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    // Crear producto
    @POST
    public Response crearProducto(ModelProducto producto) {
        productoService.crearProducto(producto);
        return Response.status(Response.Status.CREATED).entity(producto).build();
    }

    // Actualizar producto
    @PUT
    @Path("/{id}")
    public Response actualizarProducto(@PathParam("id") Long id, ModelProducto producto) {
        ModelProducto actualizado = productoService.actualizarProducto(id, producto);
        if (actualizado != null) {
            return Response.ok(actualizado).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    // Eliminar producto
    @DELETE
    @Path("/{id}")
    public Response eliminarProducto(@PathParam("id") Long id) {
        productoService.eliminarProducto(id);
        return Response.noContent().build();
    }
}
