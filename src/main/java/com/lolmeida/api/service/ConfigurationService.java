package com.lolmeida.api.service;


import java.util.List;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;

import com.lolmeida.api.RepositoryApi;
import com.lolmeida.api.entity.database.Configuration;
import com.lolmeida.api.repository.ConfigurationRepositoryApi;

@RequestScoped
public class ConfigurationService implements RepositoryApi<Configuration> {

    @Inject
    ConfigurationRepositoryApi repository;

    @Override
    public List<Configuration> findAll(String... orderByColumns) {
        return repository.findAll(orderByColumns);
    }

    @Override
    public List<Configuration> search(String field, String value) {
        return repository.search(field, value);
    }

    @Override
    public Configuration findBy(String id) {
        return repository.findBy(id);
    }


    @Override
    public String save(Configuration entity) {
        return repository.save(entity);
    }
}
