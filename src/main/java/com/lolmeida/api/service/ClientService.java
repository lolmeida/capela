package com.lolmeida.api.service;

import java.util.List;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;

import com.lolmeida.PeahRepository;
import com.lolmeida.api.entity.database.Client;
import com.lolmeida.api.repository.ClientRepository;

@RequestScoped
public class ClientService implements PeahRepository<Client> {
    @Inject
    ClientRepository repository;

    @Inject NotificationService notification;

    @Override
    public List<Client> findAll(final String... orderByColumns) {
        return  repository.findAll(orderByColumns);
    }

    @Override
    public List<Client> search(final String field, final String value) {
        return repository.search(field, value);
    }

    @Override
    public List<Client> findBy(final String id) {
        return repository.findBy(id);
    }

    @Override
    public String save(final Client entity) {
        String entityId = repository.save(entity);
        notification.sendTwilioMessage(
                entity.getPhoneNumber(),
                String.format("Olá %s, Seja bem vindo. Temos muito gosto em ter voçê connosco!", entity.getName()));
        return entityId;
    }


}
