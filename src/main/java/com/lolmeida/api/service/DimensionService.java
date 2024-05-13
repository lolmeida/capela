package com.lolmeida.api.service;

import com.lolmeida.api.entity.database.Size;
import com.lolmeida.api.repository.DimensionRepository;
import com.lolmeida.api.repository.PeahRepository;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;

import java.util.List;

@RequestScoped
public class DimensionService implements PeahRepository<Size> {
    @Inject
    DimensionRepository repository;

    @Override
    public List<Size> findAll(String... orderByColumns){
        return  repository.findAll(orderByColumns);
    }

    @Override
    public List<Size> search(String field, String value) {
        return repository.search(field, value);
    }

    @Override
    public List<Size> findBy(String id) {
        return repository.findBy(id);
    }

    public String save(Size entity){return repository.save(entity);}
}
