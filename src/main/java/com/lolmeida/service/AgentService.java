package com.lolmeida.service;

import com.lolmeida.PeahRepository;
import com.lolmeida.entity.database.Agent;
import com.lolmeida.repository.AgentRepository;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;

import java.util.List;

@RequestScoped
public class AgentService implements PeahRepository<Agent> {
    @Inject
    AgentRepository repository;

    @Override
    public List<Agent> findAll(String... orderByColumns){
        return  repository.findAll(orderByColumns);
    }

    @Override
    public List<Agent> search(String field, String value) {
        return repository.search(field, value);
    }

    @Override
    public List<Agent> findBy(String id) {
        return repository.findBy(id);
    }

    @Override
    public String save(Agent entity) {
        return repository.save(entity);
    }
}
