package com.lolmeida.api.repository;

import java.util.List;
import java.util.UUID;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import io.quarkus.panache.common.Sort;
import io.smallrye.common.constraint.NotNull;

import com.lolmeida.PeahRepository;
import com.lolmeida.api.entity.database.Cargo;

@ApplicationScoped
public class CargaPeahRepository implements PanacheRepositoryBase<Cargo, UUID>, PeahRepository<Cargo> {

    @Override
    public List<Cargo> findAll(final String... orderByColumns) {
        return listAll(Sort.descending(orderByColumns)).stream().toList();
    }
    @Override
    public List<Cargo> search(@NotNull final String field, @NotNull final String value) {
        final String searchInput = "%" + value.toLowerCase() + "%";
        return list("LOWER(" + field + ") like ?1", searchInput.toLowerCase());
    }
    @Override
    public List<Cargo> findBy(final String id) {
        return list("Client like ?1", id);
    }

    @Override
    @Transactional
    public String save(final Cargo entity) {
        persistAndFlush(entity);
        return entity.getId();
    }


}
