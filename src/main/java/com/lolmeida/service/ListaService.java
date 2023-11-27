package com.lolmeida.service;

import com.lolmeida.Repository;
import com.lolmeida.entity.database.Dimensao;
import com.lolmeida.entity.database.Lista;
import com.lolmeida.repository.DimensaoRepository;
import com.lolmeida.repository.ListaRepository;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;

import java.util.List;

@RequestScoped
public class ListaService implements Repository<Lista> {
    @Inject
    ListaRepository repository;

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
}
