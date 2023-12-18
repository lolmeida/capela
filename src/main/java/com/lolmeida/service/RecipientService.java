package com.lolmeida.service;

import com.lolmeida.PeahRepository;
import com.lolmeida.entity.database.Recipient;
import com.lolmeida.repository.RecipientRepository;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;

import java.util.List;

@RequestScoped
public class RecipientService implements PeahRepository<Recipient> {
    @Inject
    RecipientRepository repository;

    @Override
    public List<Recipient> findAll(String... orderByColumns){
        return  repository.findAll(orderByColumns);
    }

    @Override
    public List<Recipient> search(String field, String value) {
        return repository.search(field, value);
    }

    @Override
    public List<Recipient> findBy(String id) {
        return repository.findBy(id);
    }

    @Override
    public String save(Recipient entity) {
        return repository.save(entity);
    }


}
