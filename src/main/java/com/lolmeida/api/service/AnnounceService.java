package com.lolmeida.api.service;


import com.lolmeida.api.entity.database.Announce;
import com.lolmeida.api.repository.AnnounceRepositoryApi;
import com.lolmeida.api.RepositoryApi;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;

import java.util.List;

@RequestScoped
public class AnnounceService implements RepositoryApi<Announce> {
    @Inject
    AnnounceRepositoryApi repository;

    @Override
    public List<Announce> findAll(String... orderByColumns){
        return  repository.findAll(orderByColumns);
    }

    @Override
    public List<Announce> search(String field, String value) {
        return repository.search(field, value);
    }

    @Override
    public List<Announce> findBy(String id) {
        return repository.findBy(id);
    }

    @Override
    public String save(Announce entity) {
        return repository.save(entity);
    }
}
