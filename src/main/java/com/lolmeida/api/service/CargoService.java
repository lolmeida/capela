package com.lolmeida.api.service;


import com.lolmeida.api.entity.database.Cargo;
import com.lolmeida.api.repository.CargoRepositoryApi;
import com.lolmeida.api.RepositoryApi;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;

import java.util.List;

@RequestScoped
public class CargoService implements RepositoryApi<Cargo> {
    @Inject
    CargoRepositoryApi repository;

    @Override
    public List<Cargo> findAll(String... orderByColumns){
        return  repository.findAll(orderByColumns);
    }

    @Override
    public List<Cargo> search(String field, String value) {
        return repository.search(field, value);
    }

    @Override
    public List<Cargo> findBy(String id) {
        return repository.findBy(id);
    }

    @Override
    public String save(Cargo entity) {
        return repository.save(entity);
    }


}
