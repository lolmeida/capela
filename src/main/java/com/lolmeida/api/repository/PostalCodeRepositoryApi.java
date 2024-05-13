package com.lolmeida.api.repository;

import java.util.List;
import java.util.UUID;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import io.quarkus.panache.common.Sort;

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
        final String searchInput = "%" + value.toLowerCase() + "%";
        return list("LOWER(" + field + ") like ?1", searchInput.toLowerCase());
    }

    @Override
    public List<PostalCode> findBy(String texto) {
        return list("Texto like ?1", texto);
    }

    @Override
    @Transactional
    public String save(PostalCode entity) {
        persistAndFlush(entity);
        return entity.getId();
    }
}
