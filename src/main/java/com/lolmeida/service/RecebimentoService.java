package com.lolmeida.service;

import com.lolmeida.entity.database.Receipt;
import com.lolmeida.repository.RecebimentoPeahRepository;
import com.lolmeida.PeahRepository;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;

import java.util.List;

@RequestScoped
public class RecebimentoService implements PeahRepository<Receipt> {
    @Inject
    RecebimentoPeahRepository repository;

    public List<Receipt> findAll(String... orderByColumns){
        return  repository.findAll(orderByColumns);
    }

    public List<Receipt> search(String field, String value) {
        return repository.search(field, value);
    }

    public List<Receipt> findBy(String id) {
        return repository.findBy(id);
    }

    @Override
    public String save(Receipt entity) {
        return repository.save(entity);
    }
}
