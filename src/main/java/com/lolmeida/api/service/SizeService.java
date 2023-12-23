package com.lolmeida.api.service;

import java.util.List;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;

import com.lolmeida.PeahRepository;
import com.lolmeida.api.entity.database.Size;
import com.lolmeida.api.repository.SizeRepository;

@RequestScoped
public class SizeService implements PeahRepository<Size> {
    @Inject
    SizeRepository repository;

    @Override
    public List<Size> findAll(final String... orderByColumns) {
        return  repository.findAll(orderByColumns);
    }

    @Override
    public List<Size> search(final String field, final String value) {
        return repository.search(field, value);
    }

    @Override
    public List<Size> findBy(final String id) {
        return repository.findBy(id);
    }

    @Override
    public String save(final Size entity) {
        return repository.save(entity);
    }


}
