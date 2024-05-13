package com.lolmeida.api.repository;


import java.util.List;
import java.util.UUID;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import io.quarkus.panache.common.Sort;

import com.lolmeida.api.AppConfig.Query;
import com.lolmeida.api.RepositoryApi;
import com.lolmeida.api.entity.database.Utilizador;

@ApplicationScoped
public class UserRepositoryApi implements PanacheRepositoryBase<Utilizador, UUID>, RepositoryApi<Utilizador> {

    public List<Utilizador> findAll(String... orderByColumns) {
        return listAll(Sort.descending(orderByColumns)).stream().toList();
    }

    public List<Utilizador> search(final String field, final String value) {
        String searchInput = String.format(Query.SEARCH_INPUT, value.toLowerCase());
        return list(String.format(Query.SEARCH, field), searchInput.toLowerCase());
    }


    @Override
    public Utilizador findBy(String id) {
        return list(Query.FIND_BY_ID, id).stream().findFirst().orElse(null);
    }

    @Override
    @Transactional
    public String save(Utilizador entity) {
        persistAndFlush(entity);
        return entity.getId();
    }

}
