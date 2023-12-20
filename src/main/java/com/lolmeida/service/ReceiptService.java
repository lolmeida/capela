package com.lolmeida.service;

import java.util.List;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;

import com.lolmeida.PeahRepository;
import com.lolmeida.entity.database.Receipt;
import com.lolmeida.repository.ReceiptRepository;

@RequestScoped
public class ReceiptService implements PeahRepository<Receipt> {
    @Inject
    ReceiptRepository repository;

    @Override
    public List<Receipt> findAll(String... orderByColumns){
        return  repository.findAll(orderByColumns);
    }

    @Override
    public List<Receipt> search(String field, String value) {
        return repository.search(field, value);
    }

    @Override
    public List<Receipt> findBy(String id) {
        return repository.findBy(id);
    }

    @Override
    public String save(Receipt entity) {
        return repository.save(entity);
    }


}
