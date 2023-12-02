package com.lolmeida.service;

import com.lolmeida.entity.database.Carga;
import com.lolmeida.repository.CargaPeahRepository;
import com.lolmeida.PeahRepository;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;

import java.util.List;

@RequestScoped
public class CargaService implements PeahRepository<Carga> {
    @Inject
    CargaPeahRepository repository;

    @Override
    public List<Carga> findAll(String... orderByColumns){
        return  repository.findAll(orderByColumns);
    }

    @Override
    public List<Carga> search(String field, String value) {
        return repository.search(field, value);
    }

    @Override
    public List<Carga> findBy(String customerId) {
        return repository.findBy(customerId);
    }

    @Override
    public void save(Carga entity) {
        repository.save(entity);
    }


}
