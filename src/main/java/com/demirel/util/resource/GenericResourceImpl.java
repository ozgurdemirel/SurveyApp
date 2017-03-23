package com.demirel.util.resource;

import com.demirel.util.GenericRepository;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.Response;
import java.io.Serializable;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Objects;
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

    public T getRepository() {
        return repository;
    }
}
