package com.lolmeida.service;

import java.util.List;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;

import com.lolmeida.PeahRepository;
import com.lolmeida.entity.database.Cargo;
import com.lolmeida.repository.CargaPeahRepository;

@RequestScoped
public class CargoService implements PeahRepository<Cargo> {
    @Inject
    CargaPeahRepository repository;

    @Override
    public List<Cargo> findAll(final String... orderByColumns) {
        return  repository.findAll(orderByColumns);
    }

    @Override
    public List<Cargo> search(final String field, final String value) {
        return repository.search(field, value);
    }

    @Override
    public List<Cargo> findBy(final String id) {
        return repository.findBy(id);
    }

    @Override
    public String save(final Cargo entity) {
        return repository.save(entity);
    }


}
