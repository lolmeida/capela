package com.lolmeida.repository;

import com.lolmeida.Repository;
import com.lolmeida.entity.database.Agente;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import io.quarkus.panache.common.Sort;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;
import java.util.UUID;

@ApplicationScoped
public class AgenteRepository implements PanacheRepositoryBase<Agente, UUID>, Repository<Agente> {

    @Override
    public List<Agente> findAll(String... orderByColumns) {
        return listAll(Sort.descending(orderByColumns)).stream().toList();
    }

    @Override
    public List<Agente> search(String field, String value) {
        final String searchInput = "%" + value.toLowerCase() + "%";
        return list("LOWER(" + field + ") like ?1", searchInput.toLowerCase());
    }

    @Override
    public List<Agente> findBy(String name) {
        return list("Nome like ?1", name);
    }
}
