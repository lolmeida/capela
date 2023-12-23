package com.lolmeida.api.service;

import java.util.List;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;

import com.lolmeida.PeahRepository;
import com.lolmeida.api.entity.database.Recipient;
import com.lolmeida.api.repository.RecipientRepository;

@RequestScoped
public class RecipientService implements PeahRepository<Recipient> {
    @Inject
    RecipientRepository repository;

    @Override
    public List<Recipient> findAll(final String... orderByColumns) {
        return  repository.findAll(orderByColumns);
    }

    @Override
    public List<Recipient> search(final String field, final String value) {
        return repository.search(field, value);
    }

    @Override
    public List<Recipient> findBy(final String id) {
        return repository.findBy(id);
    }

    @Override
    public String save(final Recipient entity) {
        return repository.save(entity);
    }


}
