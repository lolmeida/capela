package com.lolmeida.service;

import com.lolmeida.entity.database.Cliente;
import com.lolmeida.repository.ClienteRepository;
import com.lolmeida.Repository;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;

import java.util.List;

@RequestScoped
public class ClienteService implements Repository<Cliente> {
    @Inject
    ClienteRepository repository;

    @Override
    public List<Cliente> findAll(String... orderByColumns){
        return  repository.findAll(orderByColumns);
    }

    @Override
    public List<Cliente> search(String field, String value) {
        return repository.search(field, value);
    }

    @Override
    public List<Cliente> findBy(String customerId) {
        return repository.findBy(customerId);
    }
}
