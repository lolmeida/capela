package com.lolmeida.repository;

import com.lolmeida.Repository;
import com.lolmeida.entity.database.Agente;
import com.lolmeida.entity.database.Anuncio;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import io.quarkus.panache.common.Sort;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;
import java.util.UUID;

@ApplicationScoped
public class AnuncioRepository implements PanacheRepositoryBase<Anuncio, UUID>, Repository<Anuncio> {

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
}
