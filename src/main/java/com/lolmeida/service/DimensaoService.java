package com.lolmeida.service;

import com.lolmeida.entity.database.Dimensao;
import com.lolmeida.repository.DimensaoRepository;
import com.lolmeida.Repository;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;

import java.util.List;

@RequestScoped
public class DimensaoService  implements Repository<Dimensao> {
    @Inject
    DimensaoRepository repository;

    @Override
    public List<Dimensao> findAll(String... orderByColumns){
        return  repository.findAll(orderByColumns);
    }

    @Override
    public List<Dimensao> search(String field, String value) {
        return repository.search(field, value);
    }

    @Override
    public List<Dimensao> findBy(String id) {
        return repository.findBy(id);
    }
}
