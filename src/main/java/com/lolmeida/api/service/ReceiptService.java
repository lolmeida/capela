package com.lolmeida.api.service;

import java.util.List;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;

import com.lolmeida.api.RepositoryApi;
import com.lolmeida.api.entity.database.Receipt;
import com.lolmeida.api.repository.ReceiptRepositoryApi;

@RequestScoped
public class ReceiptService implements RepositoryApi<Receipt> {

    @Inject
    ReceiptRepositoryApi repository;

    public List<Receipt> findAll(String... orderByColumns) {
        return repository.findAll(orderByColumns);
    }

    public List<Receipt> search(String field, String value) {
        return repository.search(field, value);
    }

    public Receipt findBy(String id) {
        return repository.findBy(id);
    }


    @Override
    public String save(Receipt entity) {
        return repository.save(entity);
    }
}
