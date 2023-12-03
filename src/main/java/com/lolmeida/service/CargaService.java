package com.lolmeida.service;

import com.lolmeida.PeahRepository;
import com.lolmeida.entity.database.Cargo;
import com.lolmeida.repository.CargaPeahRepository;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;

import java.util.List;

@RequestScoped
public class CargaService implements PeahRepository<Cargo> {
    @Inject
    CargaPeahRepository repository;

    @Override
    public List<Cargo> findAll(String... orderByColumns){
        return  repository.findAll(orderByColumns);
    }

    @Override
    public List<Cargo> search(String field, String value) {
        return repository.search(field, value);
    }

    @Override
    public List<Cargo> findBy(String id) {
        return repository.findBy(id);
    }

    @Override
    public String save(Cargo entity) {
        return repository.save(entity);
    }


}
