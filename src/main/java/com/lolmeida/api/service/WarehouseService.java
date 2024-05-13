package com.lolmeida.api.service;

import java.util.List;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;

import com.lolmeida.api.RepositoryApi;
import com.lolmeida.api.entity.database.Warehouse;
import com.lolmeida.api.repository.WarehouseRepositoryApi;

@RequestScoped
public class WarehouseService implements RepositoryApi<Warehouse> {

    @Inject
    WarehouseRepositoryApi repository;

    @Override
    public List<Warehouse> findAll(String... orderByColumns) {
        return repository.findAll(orderByColumns);
    }

    @Override
    public List<Warehouse> search(String field, String value) {
        return repository.search(field, value);
    }

    @Override
    public Warehouse findBy(String id) {
        return repository.findBy(id);
    }


    @Override
    public String save(Warehouse entity) {
        return repository.save(entity);
    }
}
