package com.lolmeida.api.repository;


import java.util.List;
import java.util.UUID;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import io.quarkus.panache.common.Sort;

import com.lolmeida.api.RepositoryApi;
import com.lolmeida.api.entity.database.Status;

@ApplicationScoped
public class StatusRepositoryApi implements PanacheRepositoryBase<Status, UUID>, RepositoryApi<Status> {

    @Override
    public List<Status> findAll(String... orderByColumns) {
        return listAll(Sort.descending(orderByColumns)).stream().toList();
    }

    @Override
    public List<Status> search(String field, String value) {
        final String searchInput = "%" + value.toLowerCase() + "%";
        return list("LOWER(" + field + ") like ?1", searchInput.toLowerCase());
    }

    @Override
    public List<Status> findBy(String tipo) {
        return list("Tipo like ?1", tipo);
    }

    @Override
    @Transactional
    public String save(Status entity) {
        persistAndFlush(entity);
        return entity.getId();
    }
}
