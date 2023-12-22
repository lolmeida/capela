package com.lolmeida.repository;

import java.util.List;
import java.util.UUID;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import io.quarkus.panache.common.Sort;
import io.smallrye.common.constraint.NotNull;

import com.lolmeida.PeahRepository;
import com.lolmeida.entity.database.Recipient;

@ApplicationScoped
public class RecipientRepository implements PanacheRepositoryBase<Recipient, UUID>, PeahRepository<Recipient> {

    @Override
    public List<Recipient> findAll(final String... orderByColumns) {
        return listAll(Sort.descending(orderByColumns)).stream().toList();
    }
    @Override
    public List<Recipient> search(@NotNull final String field, @NotNull final String value) {
        final String searchInput = "%" + value.toLowerCase() + "%";
        return list("LOWER(" + field + ") like ?1", searchInput.toLowerCase());
    }
    @Override
    public List<Recipient> findBy(final String id) {
        return list("id like ?1", id);
    }

    @Override
    @Transactional
    public String save(final Recipient entity) {
        persistAndFlush(entity);
        return entity.getId();
    }


}
