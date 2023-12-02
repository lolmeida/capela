package com.lolmeida.service;

import com.lolmeida.entity.database.Recebimento;
import com.lolmeida.repository.RecebimentoPeahRepository;
import com.lolmeida.PeahRepository;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;

import java.util.List;

@RequestScoped
public class RecebimentoService implements PeahRepository<Recebimento> {
    @Inject
    RecebimentoPeahRepository repository;

    public List<Recebimento> findAll(String... orderByColumns){
        return  repository.findAll(orderByColumns);
    }

    public List<Recebimento> search(String field, String value) {
        return repository.search(field, value);
    }

    public List<Recebimento> findBy(String customerId) {
        return repository.findBy(customerId);
    }

    @Override
    public String save(Recebimento entity) {
        return repository.save(entity);
    }
}
