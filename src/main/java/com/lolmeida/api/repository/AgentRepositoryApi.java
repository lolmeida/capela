package com.lolmeida.api.repository;

import java.util.List;
import java.util.UUID;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import io.quarkus.panache.common.Sort;

import com.lolmeida.api.RepositoryApi;
import com.lolmeida.api.entity.database.Agent;

@ApplicationScoped
public class AgentRepositoryApi implements PanacheRepositoryBase<Agent, UUID>, RepositoryApi<Agent> {

    @Override
    public List<Agent> findAll(String... orderByColumns) {
        return listAll(Sort.descending(orderByColumns)).stream().toList();
    }

    @Override
    public List<Agent> search(String field, String value) {
        final String searchInput = "%" + value.toLowerCase() + "%";
        return list("LOWER(" + field + ") like ?1", searchInput.toLowerCase());
    }

    @Override
    public List<Agent> findBy(String name) {
        return list("id like ?1", name);
    }

    @Override
    @Transactional
    public String save(Agent entity) {
        persistAndFlush(entity);
        return entity.getId();
    }
}
