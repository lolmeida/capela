package com.lolmeida.repository;

import com.lolmeida.PeahRepository;
import com.lolmeida.entity.database.PostalCode;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import io.quarkus.panache.common.Sort;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.UUID;

@ApplicationScoped
public class CodigoPostalPeahRepository implements PanacheRepositoryBase<PostalCode, UUID>, PeahRepository<PostalCode> {

    @Override
    public List<PostalCode> findAll(String... orderByColumns) {
        return listAll(Sort.descending(orderByColumns)).stream().toList();
    }

    @Override
    public List<PostalCode> search(String field, String value) {
        final String searchInput = "%" + value.toLowerCase() + "%";
        return list("LOWER(" + field + ") like ?1", searchInput.toLowerCase());
    }

    @Override
    public List<PostalCode> findBy(String texto) {
        return list("Texto like ?1", texto);
    }

    @Override
    @Transactional
    public String save(PostalCode entity) {
        persistAndFlush(entity);
        return entity.getId();
    }
}
