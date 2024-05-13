package com.lolmeida.api.repository;

import java.util.List;
import java.util.UUID;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import io.quarkus.panache.common.Sort;

import com.lolmeida.api.AppConfig.Query;
import com.lolmeida.api.RepositoryApi;
import com.lolmeida.api.entity.database.PostalCode;

@ApplicationScoped
public class PostalCodeRepositoryApi implements PanacheRepositoryBase<PostalCode, UUID>, RepositoryApi<PostalCode> {

    @Override
    public List<PostalCode> findAll(String... orderByColumns) {
        return listAll(Sort.descending(orderByColumns)).stream().toList();
    }

    @Override
    public List<PostalCode> search(String field, String value) {
        String searchInput = String.format(Query.SEARCH_INPUT, value.toLowerCase());
        return list(String.format(Query.SEARCH, field), searchInput.toLowerCase());
    }

    @Override
    public PostalCode findBy(String id) {
        return list(Query.FIND_BY_ID, id).stream().findFirst().orElse(null);
    }

    @Override
    @Transactional
    public String save(PostalCode entity) {
        persistAndFlush(entity);
        return entity.getId();
    }
}
