package com.lolmeida.repository;

import java.util.List;
import java.util.UUID;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import io.quarkus.panache.common.Sort;
import io.smallrye.common.constraint.NotNull;

import com.lolmeida.PeahRepository;
import com.lolmeida.entity.database.Client;

@ApplicationScoped
public class ClientRepository implements PanacheRepositoryBase<Client, UUID>, PeahRepository<Client> {

    @Override
    public List<Client> findAll(String... orderByColumns) {
        return listAll(Sort.descending(orderByColumns)).stream().toList();
    }
    @Override
    public List<Client> search(@NotNull final String field, @NotNull final String value) {
        final String searchInput = "%" + value.toLowerCase() + "%";
        return list("LOWER(" + field + ") like ?1", searchInput.toLowerCase());
    }
    @Override
    public List<Client> findBy(final String id) {
        return list("Client like ?1", id);
    }

    @Override
    @Transactional
    public String save(Client entity) {
        persistAndFlush(entity);
        return entity.getId();
    }


}
