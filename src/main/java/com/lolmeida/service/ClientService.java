package com.lolmeida.service;

import com.lolmeida.entity.database.Client;
import com.lolmeida.repository.ClientRepository;
import com.lolmeida.PeahRepository;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;

import java.util.List;

@RequestScoped
public class ClientService implements PeahRepository<Client> {
    @Inject
    ClientRepository repository;

    @Override
    public List<Client> findAll(String... orderByColumns){
        return  repository.findAll(orderByColumns);
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
