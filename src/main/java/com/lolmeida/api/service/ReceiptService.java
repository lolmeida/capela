package com.lolmeida.api.service;

import com.lolmeida.api.entity.database.Receipt;
import com.lolmeida.api.repository.ReceiptRepository;
import com.lolmeida.api.repository.PeahRepository;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;

import java.util.List;

@RequestScoped
public class ReceiptService implements PeahRepository<Receipt> {
    @Inject
    ReceiptRepository repository;

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
