package com.lolmeida.api.service;


import java.util.List;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;

import com.lolmeida.api.RepositoryApi;
import com.lolmeida.api.entity.database.Status;
import com.lolmeida.api.repository.StatusRepositoryApi;

@RequestScoped
public class StatusService implements RepositoryApi<Status> {

    @Inject
    StatusRepositoryApi repository;

    @Override
    public List<Status> findAll(String... orderByColumns) {
        return repository.findAll(orderByColumns);
    }

    @Override
    public List<Status> search(String field, String value) {
        return repository.search(field, value);
    }

    @Override
    public List<Status> findBy(String id) {
        return repository.findBy(id);
    }

    @Override
    public String save(Status entity) {
        return repository.save(entity);
    }
}
