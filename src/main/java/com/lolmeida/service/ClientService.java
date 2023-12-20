package com.lolmeida.service;

import java.util.List;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;

import com.lolmeida.PeahRepository;
import com.lolmeida.entity.database.Client;
import com.lolmeida.repository.ClientRepository;

@RequestScoped
public class ClientService implements PeahRepository<Client> {
    @Inject
    ClientRepository repository;

    @Inject NotificationService notification;

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
        String entityId = repository.save(entity);
        notification.sendTwilioMessage(
                entity.getPhoneNumber(),
                String.format("Olá %s, Seja bem vindo. Temos muito gosto em ter voçê connosco!", entity.getName()));
        return entityId;
    }


}
