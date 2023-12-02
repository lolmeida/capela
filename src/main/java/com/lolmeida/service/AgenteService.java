package com.lolmeida.service;

import com.lolmeida.PeahRepository;
import com.lolmeida.entity.database.Agente;
import com.lolmeida.repository.AgentePeahRepository;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;

import java.util.List;

@RequestScoped
public class AgenteService implements PeahRepository<Agente> {
    @Inject
    AgentePeahRepository repository;

    @Override
    public List<Agente> findAll(String... orderByColumns){
        return  repository.findAll(orderByColumns);
    }

    @Override
    public List<Agente> search(String field, String value) {
        return repository.search(field, value);
    }

    @Override
    public List<Agente> findBy(String customerId) {
        return repository.findBy(customerId);
    }

    @Override
    public void save(Agente entity) {
        repository.save(entity);
    }
}
