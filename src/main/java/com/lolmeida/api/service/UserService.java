package com.lolmeida.api.service;

import java.util.List;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;

import com.lolmeida.PeahRepository;
import com.lolmeida.api.entity.database.User;
import com.lolmeida.api.repository.UserRepository;

@RequestScoped
public class UserService implements PeahRepository<User> {

    @Inject
    UserRepository repository;

    @Override
    public List<User> findAll(final String... orderByColumns) {
        return repository.findAll(orderByColumns);
    }

    @Override
    public List<User> search(final String field, final String value) {
        return repository.search(field, value);
    }

    @Override
    public List<User> findBy(final String id) {
        return repository.findBy(id);
    }

    @Override
    public String save(final User entity) {
        return repository.save(entity);
    }


}
