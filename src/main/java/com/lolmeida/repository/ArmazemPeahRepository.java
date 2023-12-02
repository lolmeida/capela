package com.lolmeida.repository;

import com.lolmeida.PeahRepository;
import com.lolmeida.entity.database.Armazem;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import io.quarkus.panache.common.Sort;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.UUID;

@ApplicationScoped
public class ArmazemPeahRepository implements PanacheRepositoryBase<Armazem, UUID>, PeahRepository<Armazem> {

    @Override
    public List<Armazem> findAll(String... orderByColumns) {
        return listAll(Sort.descending(orderByColumns)).stream().toList();
    }

    @Override
    public List<Armazem> search(String field, String value) {
        final String searchInput = "%" + value.toLowerCase() + "%";
        return list("LOWER(" + field + ") like ?1", searchInput.toLowerCase());
    }

    @Override
    public List<Armazem> findBy(String customerId) {
        return list("Cliente like ?1", customerId);
    }

    @Override
    @Transactional
    public String save(Armazem entity) {
        persistAndFlush(entity);
        return entity.getId();
    }
}
