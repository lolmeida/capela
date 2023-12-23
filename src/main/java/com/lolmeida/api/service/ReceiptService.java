package com.lolmeida.api.service;

import java.util.List;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;

import com.lolmeida.PeahRepository;
import com.lolmeida.api.entity.database.Receipt;
import com.lolmeida.api.repository.ReceiptRepository;

@RequestScoped
public class ReceiptService implements PeahRepository<Receipt> {
    @Inject
    ReceiptRepository repository;

    @Override
    public List<Receipt> findAll(final String... orderByColumns) {
        return  repository.findAll(orderByColumns);
    }

    @Override
    public List<Receipt> search(final String field, final String value) {
        return repository.search(field, value);
    }

    @Override
    public List<Receipt> findBy(final String id) {
        return repository.findBy(id);
    }

    @Override
    public String save(final Receipt entity) {
        return repository.save(entity);
    }


}
