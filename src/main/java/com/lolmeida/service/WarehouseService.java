package com.lolmeida.service;

import com.lolmeida.PeahRepository;
import com.lolmeida.entity.database.Warehouse;
import com.lolmeida.repository.WarehouseRepository;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;

import java.util.List;

@RequestScoped
public class WarehouseService implements PeahRepository<Warehouse> {
    @Inject
    WarehouseRepository repository;

    @Override
    public List<Warehouse> findAll(String... orderByColumns){
        return  repository.findAll(orderByColumns);
    }

    @Override
    public List<Warehouse> search(String field, String value) {
        return repository.search(field, value);
    }

    @Override
    public List<Warehouse> findBy(String id) {
        return repository.findBy(id);
    }

    @Override
    public String save(Warehouse entity) {
        return repository.save(entity);
    }
}
