package com.lolmeida.repository;

import com.lolmeida.PeahRepository;
import com.lolmeida.entity.database.Cargo;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import io.quarkus.panache.common.Sort;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.UUID;

@ApplicationScoped
public class CargoRepository implements PanacheRepositoryBase<Cargo, UUID>, PeahRepository<Cargo> {
    @Override
    public List<Cargo> findAll(String... orderByColumns) {
        return listAll(Sort.descending(orderByColumns)).stream().toList();
    }
    @Override
    public List<Cargo> search(final String field, final String value) {
        final String searchInput = "%" + value.toLowerCase() + "%";
        return list("LOWER(" + field + ") like ?1", searchInput.toLowerCase());
    }
    @Override
    public List<Cargo> findBy(final String id) {
        return list("Client like ?1", id);
    }

    @Override
    @Transactional
    public String save(Cargo entity) {
        persistAndFlush(entity);
        return entity.getId();
    }


}
