package com.lolmeida.service;

import com.lolmeida.PeahRepository;
import com.lolmeida.entity.database.Anuncio;
import com.lolmeida.repository.AnuncioPeahRepository;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;

import java.util.List;

@RequestScoped
public class AnuncioService implements PeahRepository<Anuncio> {
    @Inject
    AnuncioPeahRepository repository;

    @Override
    public List<Anuncio> findAll(String... orderByColumns){
        return  repository.findAll(orderByColumns);
    }

    @Override
    public List<Anuncio> search(String field, String value) {
        return repository.search(field, value);
    }

    @Override
    public List<Anuncio> findBy(String customerId) {
        return repository.findBy(customerId);
    }

    @Override
    public void save(Anuncio entity) {
        repository.save(entity);
    }
}
