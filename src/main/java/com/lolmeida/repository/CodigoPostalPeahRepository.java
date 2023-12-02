package com.lolmeida.repository;

import com.lolmeida.PeahRepository;
import com.lolmeida.entity.database.CodigoPostal;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import io.quarkus.panache.common.Sort;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.UUID;

@ApplicationScoped
public class CodigoPostalPeahRepository implements PanacheRepositoryBase<CodigoPostal, UUID>, PeahRepository<CodigoPostal> {

    @Override
    public List<CodigoPostal> findAll(String... orderByColumns) {
        return listAll(Sort.descending(orderByColumns)).stream().toList();
    }

    @Override
    public List<CodigoPostal> search(String field, String value) {
        final String searchInput = "%" + value.toLowerCase() + "%";
        return list("LOWER(" + field + ") like ?1", searchInput.toLowerCase());
    }

    @Override
    public List<CodigoPostal> findBy(String texto) {
        return list("Texto like ?1", texto);
    }

    @Override
    @Transactional
    public String save(CodigoPostal entity) {
        persistAndFlush(entity);
        return entity.getId();
    }
}
