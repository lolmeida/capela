package com.lolmeida.api.service;

import com.lolmeida.api.entity.database.Receipt;
import com.lolmeida.api.repository.ReceiptRepositoryApi;
import com.lolmeida.api.RepositoryApi;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;

import java.util.List;

@RequestScoped
public class ReceiptService implements RepositoryApi<Receipt> {
    @Inject
    ReceiptRepositoryApi repository;

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