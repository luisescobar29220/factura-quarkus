import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/cliente")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ClienteResource {

    @Inject
    ClienteService clienteService;

    @GET
    public List<ModelCliente> listarCliente(){
        return clienteService.listarClientes();
    }

    //buscar cliente id
    @GET
    @Path("/{id}")
    public Response buscarCliente(@PathParam("id") Long id){
        ModelCliente cliente = clienteService.buscarId(id);
        if(cliente != null){
            return Response.ok(cliente).build();
        }
        else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

    }
    // Crear cliente
    @POST
    public Response crearCliente(ModelCliente cliente) {
        clienteService.crearCliente(cliente);
        return Response.status(Response.Status.CREATED).entity(cliente).build();
    }


    // Actualizar cliente
    @PUT
    @Path("/{id}")
    public Response actualizarCliente(@PathParam("id") Long id, ModelCliente cliente) {
        ModelCliente actualizado = clienteService.actualizarCliente(id, cliente);
        if (actualizado != null) {
            return Response.ok(actualizado).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    // Eliminar cliente
    @DELETE
    @Path("/{id}")
    public Response eliminarCliente(@PathParam("id") Long id) {
        clienteService.eliminarCliente(id);
        return Response.noContent().build();
    }

}
