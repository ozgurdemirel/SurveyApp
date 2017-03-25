package com.demirel.common.base.repository;

import java.io.Serializable;
import java.util.List;

public interface GenericRepository<T extends Serializable> {
    T add(T entity);

    T findById(Long id);

    void update(T entity);

    List<T> findAll(String orderField);

    boolean alreadyExists(String propertyName, String propertyValue, Long id);

    boolean existsById(Long id);
}
