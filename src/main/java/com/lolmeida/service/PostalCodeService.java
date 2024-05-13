package com.lolmeida.service;

import com.lolmeida.PeahRepository;
import com.lolmeida.entity.database.PostalCode;
import com.lolmeida.repository.PostalCodeRepository;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;

import java.util.List;

@RequestScoped
public class PostalCodeService implements PeahRepository<PostalCode> {
    @Inject
    PostalCodeRepository repository;

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
