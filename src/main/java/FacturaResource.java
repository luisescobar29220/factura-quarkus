import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/factura")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Transactional
public class FacturaResource {

    @Inject
    FacturaService facturaService;

    // Listar todas las facturas
    @GET
    public List<ModelFactura> listarFacturas() {
        return facturaService.listarFacturas();
    }

    // Buscar factura por ID
    @GET
    @Path("/{id}")
    public Response obtenerFactura(@PathParam("id") Long id) {
        ModelFactura factura = facturaService.obtenerFacturaPorId(id);
        if (factura == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(factura).build();
    }

    // Crear factura con clienteId y productoId
    @POST
    @Path("/{clienteId}/{productoId}")
    public Response crearFactura(@PathParam("clienteId") Long clienteId,
                                 @PathParam("productoId") Long productoId,
                                 ModelFactura factura) {
        ModelFactura nueva = facturaService.crearFactura(factura, clienteId, productoId);
        return Response.status(Response.Status.CREATED).entity(nueva).build();
    }

    // Eliminar factura
    @DELETE
    @Path("/{id}")
    public Response eliminarFactura(@PathParam("id") Long id) {
        facturaService.eliminarFactura(id);
        return Response.noContent().build();
    }

    // Actualizar factura
    @PUT
    @Path("/{id}/{clienteId}/{productoId}")
    public Response actualizarFactura(@PathParam("id") Long id,
                                      @PathParam("clienteId") Long clienteId,
                                      @PathParam("productoId") Long productoId,
                                      ModelFactura factura) {
        ModelFactura actualizada = facturaService.actualizarFactura(id, factura, clienteId, productoId);
        return Response.ok(actualizada).build();
    }
}
