package com.lolmeida.api.repository;

import com.lolmeida.api.entity.database.Announce;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import io.quarkus.panache.common.Sort;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.UUID;

@ApplicationScoped
public class AnnounceRepository implements PanacheRepositoryBase<Announce, UUID>, PeahRepository<Announce> {

    @Override
    public List<Announce> findAll(String... orderByColumns) {
        return listAll(Sort.descending(orderByColumns)).stream().toList();
    }

    @Override
    public List<Announce> search(String field, String value) {
        final String searchInput = "%" + value.toLowerCase() + "%";
        return list("LOWER(" + field + ") like ?1", searchInput.toLowerCase());
    }

    @Override
    public List<Announce> findBy(String titulo) {
        return list("Titulo like ?1", titulo);
    }

    @Override
    @Transactional
    public String save(Announce entity) {
        persistAndFlush(entity);
        return entity.getId();
    }
}
