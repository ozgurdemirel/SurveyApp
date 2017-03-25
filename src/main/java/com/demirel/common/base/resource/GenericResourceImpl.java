package com.demirel.common.base.resource;

import com.demirel.common.base.repository.GenericRepository;
import com.demirel.model.Survey;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.Response;
import java.io.Serializable;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.logging.Logger;

public abstract class GenericResourceImpl<T extends GenericRepository,E extends Serializable> implements GenericResource<E> {
    @Inject
    private Logger logger;

    private T repository;

    @Inject
    Instance<T> instanceOfRepository;

    @PostConstruct
    public void init(){
        repository = instanceOfRepository.get();
    }

    @Override
    public Response findAll() {
        return Response.ok().entity(new GenericEntity<List<Object>>( repository.findAll("id")){}).build();
    }

    @Override
    public Response save(E dto) {
        try {
            return Response.created(new URI("http://localhost")).entity(dto).build();
        } catch (URISyntaxException e) {
            e.printStackTrace(); /// handle or throw
        }
        return null;
    }

    @Override
    public Response findById(Long id) {
        return Response.ok().entity(repository.findById(id)).build();
    }


    public Response update(E entity) {
        repository.update(entity);
        return Response.ok().build();
    }

}
