package com.lolmeida.service;

import com.lolmeida.Repository;
import com.lolmeida.entity.database.Lista;
import com.lolmeida.entity.database.Status;
import com.lolmeida.repository.ListaRepository;
import com.lolmeida.repository.StatusRepository;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;

import java.util.List;

@RequestScoped
public class StatusService implements Repository<Status> {
    @Inject
    StatusRepository repository;

    @Override
    public List<Status> findAll(String... orderByColumns){
        return  repository.findAll(orderByColumns);
    }

    @Override
    public List<Status> search(String field, String value) {
        return repository.search(field, value);
    }

    @Override
    public List<Status> findBy(String id) {
        return repository.findBy(id);
    }
}
