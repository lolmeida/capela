package com.lolmeida.repository;

import com.lolmeida.PeahRepository;
import com.lolmeida.entity.database.Carga;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import io.quarkus.panache.common.Sort;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.UUID;

@ApplicationScoped
public class CargaPeahRepository implements PanacheRepositoryBase<Carga, UUID>, PeahRepository<Carga> {
    @Override
    public List<Carga> findAll(String... orderByColumns) {
        return listAll(Sort.descending(orderByColumns)).stream().toList();
    }
    @Override
    public List<Carga> search(final String field, final String value) {
        final String searchInput = "%" + value.toLowerCase() + "%";
        return list("LOWER(" + field + ") like ?1", searchInput.toLowerCase());
    }
    @Override
    public List<Carga> findBy(final String customerId) {
        return list("Cliente like ?1", customerId);
    }

    @Override
    @Transactional
    public String save(Carga entity) {
        persistAndFlush(entity);
        return entity.getIdRegisto();
    }


}
