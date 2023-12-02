package com.lolmeida.service;

import com.lolmeida.entity.database.Dimensao;
import com.lolmeida.repository.DimensaoPeahRepository;
import com.lolmeida.PeahRepository;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;

import java.util.List;

@RequestScoped
public class DimensaoService  implements PeahRepository<Dimensao> {
    @Inject
    DimensaoPeahRepository repository;

    @Override
    public List<Dimensao> findAll(String... orderByColumns){
        return  repository.findAll(orderByColumns);
    }

    @Override
    public List<Dimensao> search(String field, String value) {
        return repository.search(field, value);
    }

    @Override
    public List<Dimensao> findBy(String id) {
        return repository.findBy(id);
    }

    public void save(Dimensao entity){repository.save(entity);}
}
