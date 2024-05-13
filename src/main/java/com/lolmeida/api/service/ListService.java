package com.lolmeida.api.service;


import java.util.List;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;

import com.lolmeida.api.RepositoryApi;
import com.lolmeida.api.entity.database.CargoSenderList;
import com.lolmeida.api.repository.ListRepositoryApi;

@RequestScoped
public class ListService implements RepositoryApi<CargoSenderList> {

    @Inject
    ListRepositoryApi repository;

    @Override
    public List<CargoSenderList> findAll(String... orderByColumns) {
        return repository.findAll(orderByColumns);
    }

    @Override
    public List<CargoSenderList> search(String field, String value) {
        return repository.search(field, value);
    }

    @Override
    public CargoSenderList findBy(String id) {
        return repository.findBy(id);
    }


    @Override
    public String save(CargoSenderList entity) {
        return repository.save(entity);
    }
}
