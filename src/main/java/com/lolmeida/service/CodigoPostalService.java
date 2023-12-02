package com.lolmeida.service;

import com.lolmeida.PeahRepository;
import com.lolmeida.entity.database.CodigoPostal;
import com.lolmeida.repository.CodigoPostalPeahRepository;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;

import java.util.List;

@RequestScoped
public class CodigoPostalService implements PeahRepository<CodigoPostal> {
    @Inject
    CodigoPostalPeahRepository repository;

    @Override
    public List<CodigoPostal> findAll(String... orderByColumns){
        return  repository.findAll(orderByColumns);
    }

    @Override
    public List<CodigoPostal> search(String field, String value) {
        return repository.search(field, value);
    }

    @Override
    public List<CodigoPostal> findBy(String customerId) {
        return repository.findBy(customerId);
    }

    @Override
    public void save(CodigoPostal entity) {
        repository.save(entity);
    }
}
