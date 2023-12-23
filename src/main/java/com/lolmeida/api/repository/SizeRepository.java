package com.lolmeida.api.repository;

import java.util.List;
import java.util.UUID;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import io.quarkus.panache.common.Sort;
import io.smallrye.common.constraint.NotNull;

import com.lolmeida.ApplicationValues.Repositories;
import com.lolmeida.ApplicationValues.Repositories.Queries;
import com.lolmeida.PeahRepository;
import com.lolmeida.api.entity.database.Size;

@ApplicationScoped
public class SizeRepository implements PanacheRepositoryBase<Size, UUID>, PeahRepository<Size> {

    @Override
    public List<Size> findAll(final String... orderByColumns) {
        return listAll(Sort.descending(orderByColumns)).stream().toList();
    }

    @Override
    public List<Size> search(
            @NotNull
            final String field,
            @NotNull
            final String value) {
        final String searchInput = Repositories.Queries.QUERY_INPUT.formatted(value);
        return list(Repositories.Queries.QUERY.formatted(field), searchInput.toLowerCase());
    }

    @Override
    public List<Size> findBy(final String id) {
        return list(Queries.FIND_BY_ID, id);
    }

    @Override
    @Transactional
    public String save(final Size entity) {
        persistAndFlush(entity);
        return entity.getId();
    }


}
