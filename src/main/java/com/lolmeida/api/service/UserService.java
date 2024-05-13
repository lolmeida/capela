package com.lolmeida.api.service;

import com.lolmeida.api.entity.database.Utilizador;
import com.lolmeida.api.repository.PeahRepository;
import com.lolmeida.api.repository.UserRepository;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;

import java.util.List;

@RequestScoped
public class UserService implements PeahRepository<Utilizador> {
    @Inject
    UserRepository repository;

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

    @Override
    public String save(Utilizador entity) {
        return repository.save(entity);
    }
}
