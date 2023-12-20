package com.lolmeida.repository;

import java.util.List;
import java.util.UUID;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import io.quarkus.panache.common.Sort;
import io.smallrye.common.constraint.NotNull;

import com.lolmeida.PeahRepository;
import com.lolmeida.entity.database.User;

@ApplicationScoped
public class UserRepository implements PanacheRepositoryBase<User, UUID>, PeahRepository<User> {

    @Override
    public List<User> findAll(String... orderByColumns) {
        return listAll(Sort.descending(orderByColumns)).stream().toList();
    }
    @Override
    public List<User> search(@NotNull final String field, @NotNull final String value) {
        final String searchInput = "%" + value.toLowerCase() + "%";
        return list("LOWER(" + field + ") like ?1", searchInput.toLowerCase());
    }
    @Override
    public List<User> findBy(final String id) {
        return list("id like ?1", id);
    }

    @Override
    @Transactional
    public String save(User entity) {
        persistAndFlush(entity);
        return entity.getId();
    }


}
