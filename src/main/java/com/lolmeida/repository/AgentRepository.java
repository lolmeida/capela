package com.lolmeida.repository;

import com.lolmeida.PeahRepository;
import com.lolmeida.entity.database.Agent;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import io.quarkus.panache.common.Sort;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.UUID;

@ApplicationScoped
public class AgentRepository implements PanacheRepositoryBase<Agent, UUID>, PeahRepository<Agent> {

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
