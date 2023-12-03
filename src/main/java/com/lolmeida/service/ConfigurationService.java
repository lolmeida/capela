package com.lolmeida.service;

import com.lolmeida.PeahRepository;
import com.lolmeida.entity.database.Configuration;
import com.lolmeida.repository.ConfigurationRepository;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;

import java.util.List;

@RequestScoped
public class ConfigurationService implements PeahRepository<Configuration> {
    @Inject
    ConfigurationRepository repository;

    @Override
    public List<Configuration> findAll(String... orderByColumns){
        return  repository.findAll(orderByColumns);
    }

    @Override
    public List<Configuration> search(String field, String value) {
        return repository.search(field, value);
    }

    @Override
    public List<Configuration> findBy(String id) {
        return repository.findBy(id);
    }

    @Override
    public String save(Configuration entity) {
        return repository.save(entity);
    }
}
