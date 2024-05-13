package com.lolmeida.api.repository;

import java.util.List;
import java.util.UUID;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import io.quarkus.panache.common.Sort;

import com.lolmeida.api.RepositoryApi;
import com.lolmeida.api.entity.database.Size;

@ApplicationScoped
public class DimensionRepositoryApi implements PanacheRepositoryBase<Size, UUID>, RepositoryApi<Size> {

    @Override
    public List<Size> findAll(String... orderByColumns) {
        return listAll(Sort.descending(orderByColumns)).stream().toList();
    }

    @Override
    public List<Size> search(final String field, final String value) {
        final String searchInput = "%" + value.toLowerCase() + "%";
        return list("LOWER(" + field + ") like ?1", searchInput.toLowerCase());
    }


    @Override
    @Transactional
    public String save(Size entity) {
        persistAndFlush(entity);
        return entity.getId();
    }

    @Override
    public List<Size> findBy(final String cargoId) {
        return list("cargo like ?1", cargoId);
    }

}
