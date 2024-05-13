package com.lolmeida.api.repository;


import java.util.List;
import java.util.UUID;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import io.quarkus.panache.common.Sort;

import com.lolmeida.api.RepositoryApi;
import com.lolmeida.api.entity.database.Utilizador;

@ApplicationScoped
public class UserRepositoryApi implements PanacheRepositoryBase<Utilizador, UUID>, RepositoryApi<Utilizador> {

    public List<Utilizador> findAll(String... orderByColumns) {
        return listAll(Sort.descending(orderByColumns)).stream().toList();
    }

    public List<Utilizador> search(final String field, final String value) {
        final String searchInput = "%" + value.toLowerCase() + "%";
        return list("LOWER(" + field + ") like ?1", searchInput.toLowerCase());
    }


    @Override
    public List<Utilizador> findBy(final String id) {
        return list("Mail like ?1", id);
    }

    @Override
    @Transactional
    public String save(Utilizador entity) {
        persistAndFlush(entity);
        return entity.getId();
    }

}
