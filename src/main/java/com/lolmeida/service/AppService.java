package com.lolmeida.service;

import com.lolmeida.Repository;
import com.lolmeida.entity.database.Anuncio;
import com.lolmeida.entity.database.App;
import com.lolmeida.repository.AnuncioRepository;
import com.lolmeida.repository.AppRepository;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;

import java.util.List;

@RequestScoped
public class AppService implements Repository<App> {
    @Inject
    AppRepository repository;

    @Override
    public List<App> findAll(String... orderByColumns){
        return  repository.findAll(orderByColumns);
    }

    @Override
    public List<App> search(String field, String value) {
        return repository.search(field, value);
    }

    @Override
    public List<App> findBy(String customerId) {
        return repository.findBy(customerId);
    }
}
