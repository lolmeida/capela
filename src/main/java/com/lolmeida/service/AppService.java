package com.lolmeida.service;

import com.lolmeida.PeahRepository;
import com.lolmeida.entity.database.App;
import com.lolmeida.repository.AppPeahRepository;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;

import java.util.List;

@RequestScoped
public class AppService implements PeahRepository<App> {
    @Inject
    AppPeahRepository repository;

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
