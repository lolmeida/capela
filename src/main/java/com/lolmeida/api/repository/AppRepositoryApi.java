package com.lolmeida.api.repository;

import java.util.List;
import java.util.UUID;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import io.quarkus.panache.common.Sort;

import com.lolmeida.api.AppConfig.Query;
import com.lolmeida.api.RepositoryApi;
import com.lolmeida.api.entity.database.App;

@ApplicationScoped
public class AppRepositoryApi implements PanacheRepositoryBase<App, UUID>, RepositoryApi<App> {

    @Override
    public List<App> findAll(String... orderByColumns) {
        return listAll(Sort.descending(orderByColumns)).stream().toList();
    }

    @Override
    public List<App> search(String field, String value) {
        final String searchInput = "%" + value.toLowerCase() + "%";
        return list(String.format(Query.SEARCH, field), searchInput.toLowerCase());
    }

    @Override
    public App findBy(String id) {
        return list(Query.FIND_BY_ID, id).stream().findFirst().orElse(null);
    }

    @Override
    @Transactional
    public String save(App entity) {
        persistAndFlush(entity);
        return entity.getAppName();
    }
}
