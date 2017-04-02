package com.demirel.common.base.resource;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import java.io.Serializable;
import java.util.List;

/**
 * Created by ozgur on 23.03.2017.
 */
public interface GenericResource<E extends Serializable> {

    @GET
    Response findAll();

    @POST
    Response save(E entity);

    @GET
    @Path("/{id}")
    Response findById(Long id);

    @PUT
    Response update(E entity);


}
