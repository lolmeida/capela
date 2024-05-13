package com.lolmeida.api.service;

import java.util.List;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;

import com.lolmeida.api.RepositoryApi;
import com.lolmeida.api.entity.database.Utilizador;
import com.lolmeida.api.repository.UserRepositoryApi;

@RequestScoped
public class UserService implements RepositoryApi<Utilizador> {

    @Inject
    UserRepositoryApi repository;

    @Override
    public List<Utilizador> findAll(String... orderByColumns) {
        return repository.findAll(orderByColumns);
    }

    @Override
    public List<Utilizador> search(String field, String value) {
        return repository.search(field, value);
    }

    @Override
    public List<Utilizador> findBy(String id) {
        return repository.findBy(id);
    }

    @Override
    public String save(Utilizador entity) {
        return repository.save(entity);
    }
}
