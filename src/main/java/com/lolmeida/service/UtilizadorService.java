package com.lolmeida.service;

import com.lolmeida.entity.database.Utilizador;
import com.lolmeida.Repository;
import com.lolmeida.repository.UtilizadorRepository;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;

import java.util.List;

@RequestScoped
public class UtilizadorService implements Repository<Utilizador> {
    @Inject
    UtilizadorRepository repository;

    @Override
    public List<Utilizador> findAll(String... orderByColumns){
        return  repository.findAll(orderByColumns);
    }

    @Override
    public List<Utilizador> search(String field, String value) {
        return repository.search(field, value);
    }

    @Override
    public List<Utilizador> findBy(String id) {
        return repository.findBy(id);
    }
}
