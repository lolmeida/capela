package com.lolmeida.service;

import com.lolmeida.entity.database.Size;
import com.lolmeida.repository.DimensaoPeahRepository;
import com.lolmeida.PeahRepository;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;

import java.util.List;

@RequestScoped
public class DimensaoService  implements PeahRepository<Size> {
    @Inject
    DimensaoPeahRepository repository;

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
