package com.lolmeida.repository;

import com.lolmeida.Repository;
import com.lolmeida.entity.database.Carga;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import io.quarkus.panache.common.Sort;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;
import java.util.UUID;

@ApplicationScoped
public class CargaRepository implements PanacheRepositoryBase<Carga, UUID> , Repository<Carga> {
    public List<Carga> findAll(String... orderByColumns){
        return listAll(Sort.descending(orderByColumns)).stream().toList();
    }

    public List<Carga> search(final String field, final String value){
        final String searchInput = "%" + value.toLowerCase() + "%";
        return list("LOWER(" + field + ") like ?1", searchInput.toLowerCase());
    }

    public List<Carga> findBy(final String customerId){
        return list("Cliente like ?1", customerId);
    }
}
