package com.lolmeida.api.repository;

import java.util.List;
import java.util.UUID;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import io.quarkus.panache.common.Sort;

import com.lolmeida.api.AppConfig.Query;
import com.lolmeida.api.RepositoryApi;
import com.lolmeida.api.entity.database.Receipt;

@ApplicationScoped
public class ReceiptRepositoryApi implements PanacheRepositoryBase<Receipt, UUID>, RepositoryApi<Receipt> {

    public List<Receipt> findAll(String... orderByColumns) {
        return listAll(Sort.descending(orderByColumns)).stream().toList();
    }

    public List<Receipt> search(final String field, final String value) {
        final String searchInput = "%" + value.toLowerCase() + "%";
        return list(String.format(Query.SEARCH, field), searchInput.toLowerCase());
    }

    @Override
    public Receipt findBy(String id) {
        return list(Query.FIND_BY_ID, id).stream().findFirst().orElse(null);
    }

    @Override
    @Transactional
    public String save(Receipt entity) {
        persistAndFlush(entity);
        return entity.getId();
    }


}
