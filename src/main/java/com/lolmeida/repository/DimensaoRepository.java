package com.lolmeida.repository;

import com.lolmeida.Repository;
import com.lolmeida.entity.database.Dimensao;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import io.quarkus.panache.common.Sort;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;
import java.util.UUID;

@ApplicationScoped
public class DimensaoRepository implements PanacheRepositoryBase<Dimensao, UUID> , Repository<Dimensao> {
    public List<Dimensao> findAll(String... orderByColumns){
        return listAll(Sort.descending(orderByColumns)).stream().toList();
    }

    public List<Dimensao> search(final String field, final String value){
        final String searchInput = "%" + value.toLowerCase() + "%";
        return list("LOWER(" + field + ") like ?1", searchInput.toLowerCase());
    }

    @Override
    public List<Dimensao> findBy(String customerId) {
        return null;
    }

    public List<Dimensao> findByCargo(final String cargoId){
        return list("Carga like ?1", cargoId);
    }


}
