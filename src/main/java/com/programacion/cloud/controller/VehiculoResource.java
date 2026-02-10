package com.programacion.cloud.controller;

import com.programacion.cloud.dto.VehiculoDTO;
import com.programacion.cloud.service.IVehiculoService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;


import java.util.List;

@Path("/vehiculos")
@ApplicationScoped
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class VehiculoResource {

    @Inject
    private IVehiculoService service;

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        var aux = service.delete(id);
        if (!aux){
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.noContent().build();
    }

    @PUT
    @Path("/{id}")
    public Response update(VehiculoDTO vehiculo, @PathParam("id") Long id) {
        service.update(vehiculo, id);
        return Response.ok(vehiculo).build();
    }

    @POST
    public Response save(VehiculoDTO vehiculo) {
        service.save(vehiculo);
        return Response.status(Response.Status.CREATED).build();

    }

    @GET
    public List<VehiculoDTO> getAll() {
        return service.getAll();
    }

}
