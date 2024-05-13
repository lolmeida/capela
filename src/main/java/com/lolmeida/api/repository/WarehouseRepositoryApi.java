package com.lolmeida.api.repository;

import java.util.List;
import java.util.UUID;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import io.quarkus.panache.common.Sort;

import com.lolmeida.api.RepositoryApi;
import com.lolmeida.api.entity.database.Warehouse;

@ApplicationScoped
public class WarehouseRepositoryApi implements PanacheRepositoryBase<Warehouse, UUID>, RepositoryApi<Warehouse> {

    @Override
    public List<Warehouse> findAll(String... orderByColumns) {
        return listAll(Sort.descending(orderByColumns)).stream().toList();
    }

    @Override
    public List<Warehouse> search(String field, String value) {
        final String searchInput = "%" + value.toLowerCase() + "%";
        return list("LOWER(" + field + ") like ?1", searchInput.toLowerCase());
    }

    @Override
    public List<Warehouse> findBy(String id) {
        return list("Client like ?1", id);
    }

    @Override
    @Transactional
    public String save(Warehouse entity) {
        persistAndFlush(entity);
        return entity.getId();
    }
}
