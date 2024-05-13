package com.lolmeida.api.service;

import java.util.List;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;

import com.lolmeida.api.RepositoryApi;
import com.lolmeida.api.entity.database.Client;
import com.lolmeida.api.repository.ClientRepositoryApi;

@RequestScoped
public class ClientService implements RepositoryApi<Client> {

    @Inject
    ClientRepositoryApi repository;

    @Override
    public List<Client> findAll(String... orderByColumns) {
        return repository.findAll(orderByColumns);
    }

    @Override
    public List<Client> search(String field, String value) {
        return repository.search(field, value);
    }

    @Override
    public List<Client> findBy(String id) {
        return repository.findBy(id);
    }

    @Override
    public String save(Client entity) {
        return repository.save(entity);
    }


}
