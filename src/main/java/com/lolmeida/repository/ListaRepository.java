package com.lolmeida.repository;

import com.lolmeida.Repository;
import com.lolmeida.entity.database.App;
import com.lolmeida.entity.database.Lista;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import io.quarkus.panache.common.Sort;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;
import java.util.UUID;

@ApplicationScoped
public class ListaRepository implements PanacheRepositoryBase<Lista, UUID>, Repository<Lista> {

    @Override
    public List<Lista> findAll(String... orderByColumns) {
        return listAll(Sort.descending(orderByColumns)).stream().toList();
    }

    @Override
    public List<Lista> search(String field, String value) {
        final String searchInput = "%" + value.toLowerCase() + "%";
        return list("LOWER(" + field + ") like ?1", searchInput.toLowerCase());
    }

    @Override
    public List<Lista> findBy(String id) {
        return list("idLista like ?1", id);
    }
}
