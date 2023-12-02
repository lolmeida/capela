package com.lolmeida.service;

import com.lolmeida.PeahRepository;
import com.lolmeida.entity.database.Lista;
import com.lolmeida.repository.ListaPeahRepository;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;

import java.util.List;

@RequestScoped
public class ListaService implements PeahRepository<Lista> {
    @Inject
    ListaPeahRepository repository;

    @Override
    public List<Lista> findAll(String... orderByColumns){
        return  repository.findAll(orderByColumns);
    }

    @Override
    public List<Lista> search(String field, String value) {
        return repository.search(field, value);
    }

    @Override
    public List<Lista> findBy(String id) {
        return repository.findBy(id);
    }

    @Override
    public String save(Lista entity) {
        return repository.save(entity);
    }
}
