package com.lolmeida.repository;

import com.lolmeida.PeahRepository;
import com.lolmeida.entity.database.Anuncio;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import io.quarkus.panache.common.Sort;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.UUID;

@ApplicationScoped
public class AnuncioPeahRepository implements PanacheRepositoryBase<Anuncio, UUID>, PeahRepository<Anuncio> {

    @Override
    public List<Anuncio> findAll(String... orderByColumns) {
        return listAll(Sort.descending(orderByColumns)).stream().toList();
    }

    @Override
    public List<Anuncio> search(String field, String value) {
        final String searchInput = "%" + value.toLowerCase() + "%";
        return list("LOWER(" + field + ") like ?1", searchInput.toLowerCase());
    }

    @Override
    public List<Anuncio> findBy(String titulo) {
        return list("Titulo like ?1", titulo);
    }

    @Override
    @Transactional
    public String save(Anuncio entity) {
        persistAndFlush(entity);
        return entity.getId();
    }
}
