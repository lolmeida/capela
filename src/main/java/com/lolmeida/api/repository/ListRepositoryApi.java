package com.lolmeida.api.repository;


import java.util.List;
import java.util.UUID;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import io.quarkus.panache.common.Sort;

import com.lolmeida.api.RepositoryApi;
import com.lolmeida.api.entity.database.CargoSenderList;

@ApplicationScoped
public class ListRepositoryApi implements PanacheRepositoryBase<CargoSenderList, UUID>,
        RepositoryApi<CargoSenderList> {

    @Override
    public List<CargoSenderList> findAll(String... orderByColumns) {
        return listAll(Sort.descending(orderByColumns)).stream().toList();
    }

    @Override
    public List<CargoSenderList> search(String field, String value) {
        final String searchInput = "%" + value.toLowerCase() + "%";
        return list("LOWER(" + field + ") like ?1", searchInput.toLowerCase());
    }

    @Override
    public List<CargoSenderList> findBy(String id) {
        return list("idLista like ?1", id);
    }

    @Override
    @Transactional
    public String save(CargoSenderList entity) {
        persistAndFlush(entity);
        return entity.getId();
    }
}
