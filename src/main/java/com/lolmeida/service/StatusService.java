package com.lolmeida.service;

import com.lolmeida.PeahRepository;
import com.lolmeida.entity.database.Status;
import com.lolmeida.repository.StatusPeahRepository;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;

import java.util.List;

@RequestScoped
public class StatusService implements PeahRepository<Status> {
    @Inject
    StatusPeahRepository repository;

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

    @Override
    public String save(Status entity) {
        return repository.save(entity);
    }
}
