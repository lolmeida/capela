package com.lolmeida.api.service;


import com.lolmeida.api.entity.database.App;
import com.lolmeida.api.repository.AppRepositoryApi;
import com.lolmeida.api.RepositoryApi;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;

import java.util.List;

@RequestScoped
public class AppService implements RepositoryApi<App> {
    @Inject
    AppRepositoryApi repository;

    @Override
    public List<App> findAll(String... orderByColumns){
        return  repository.findAll(orderByColumns);
    }

    @Override
    public List<App> search(String field, String value) {
        return repository.search(field, value);
    }

    @Override
    public List<App> findBy(String id) {
        return repository.findBy(id);
    }

    @Override
    public String save(App entity) {
        return repository.save(entity);
    }
}