package com.lolmeida.api.service;

import com.lolmeida.api.RepositoryApi;
import com.lolmeida.api.entity.database.PostalCode;
import com.lolmeida.api.repository.PostalCodeRepositoryApi;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;

import java.util.List;

@RequestScoped
public class PostalCodeService implements RepositoryApi<PostalCode> {
    @Inject
    PostalCodeRepositoryApi repository;

    @Override
    public List<PostalCode> findAll(String... orderByColumns){
        return  repository.findAll(orderByColumns);
    }

    @Override
    public List<PostalCode> search(String field, String value) {
        return repository.search(field, value);
    }

    @Override
    public List<PostalCode> findBy(String id) {
        return repository.findBy(id);
    }

    @Override
    public String save(PostalCode entity) {
        return repository.save(entity);
    }
}
