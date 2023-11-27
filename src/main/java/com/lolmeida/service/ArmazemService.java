package com.lolmeida.service;

import com.lolmeida.Repository;
import com.lolmeida.entity.database.App;
import com.lolmeida.entity.database.Armazem;
import com.lolmeida.repository.AppRepository;
import com.lolmeida.repository.ArmazemRepository;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;

import java.util.List;

@RequestScoped
public class ArmazemService implements Repository<Armazem> {
    @Inject
    ArmazemRepository repository;

    @Override
    public List<Armazem> findAll(String... orderByColumns){
        return  repository.findAll(orderByColumns);
    }

    @Override
    public List<Armazem> search(String field, String value) {
        return repository.search(field, value);
    }

    @Override
    public List<Armazem> findBy(String customerId) {
        return repository.findBy(customerId);
    }
}
