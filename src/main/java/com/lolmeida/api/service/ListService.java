package com.lolmeida.api.service;


import com.lolmeida.api.entity.database.CargoSenderList;
import com.lolmeida.api.repository.ListRepository;
import com.lolmeida.api.repository.PeahRepository;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;

import java.util.List;

@RequestScoped
public class ListService implements PeahRepository<CargoSenderList> {
    @Inject
    ListRepository repository;

    @Override
    public List<CargoSenderList> findAll(String... orderByColumns){
        return  repository.findAll(orderByColumns);
    }

    @Override
    public List<CargoSenderList> search(String field, String value) {
        return repository.search(field, value);
    }

    @Override
    public List<CargoSenderList> findBy(String id) {
        return repository.findBy(id);
    }

    @Override
    public String save(CargoSenderList entity) {
        return repository.save(entity);
    }
}
