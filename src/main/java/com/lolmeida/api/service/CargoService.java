package com.lolmeida.api.service;


import java.util.List;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;

import com.lolmeida.api.RepositoryApi;
import com.lolmeida.api.entity.database.Cargo;
import com.lolmeida.api.repository.CargoRepositoryApi;

@RequestScoped
public class CargoService implements RepositoryApi<Cargo> {

    @Inject
    CargoRepositoryApi repository;

    @Override
    public List<Cargo> findAll(String... orderByColumns) {
        return repository.findAll(orderByColumns);
    }

    @Override
    public List<Cargo> search(String field, String value) {
        return repository.search(field, value);
    }

    @Override
    public Cargo findBy(String id) {
        return repository.findBy(id);
    }


    @Override
    public String save(Cargo entity) {
        return repository.save(entity);
    }


}
