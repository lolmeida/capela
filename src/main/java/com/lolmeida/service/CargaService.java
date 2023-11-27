package com.lolmeida.service;

import com.lolmeida.entity.database.Carga;
import com.lolmeida.repository.CargaRepository;
import com.lolmeida.Repository;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;

import java.util.List;

@RequestScoped
public class CargaService implements Repository<Carga> {
    @Inject
    CargaRepository repository;

    @Override
    public List<Carga> findAll(String... orderByColumns){
        return  repository.findAll(orderByColumns);
    }

    @Override
    public List<Carga> search(String field, String value) {
        return repository.search(field, value);
    }

    @Override
    public List<Carga> findBy(String customerId) {
        return repository.findBy(customerId);
    }
}
