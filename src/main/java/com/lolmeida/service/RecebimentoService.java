package com.lolmeida.service;

import com.lolmeida.entity.database.Recebimento;
import com.lolmeida.repository.RecebimentoRepository;
import com.lolmeida.Repository;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;

import java.util.List;

@RequestScoped
public class RecebimentoService implements Repository<Recebimento> {
    @Inject
    RecebimentoRepository repository;

    public List<Recebimento> findAll(String... orderByColumns){
        return  repository.findAll(orderByColumns);
    }

    public List<Recebimento> search(String field, String value) {
        return repository.search(field, value);
    }

    public List<Recebimento> findBy(String customerId) {
        return repository.findBy(customerId);
    }
}
