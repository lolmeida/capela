package com.lolmeida.repository;

import com.lolmeida.Repository;
import com.lolmeida.entity.database.Cliente;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import io.quarkus.panache.common.Sort;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;
import java.util.UUID;

@ApplicationScoped
public class ClienteRepository implements PanacheRepositoryBase<Cliente, UUID> , Repository<Cliente> {
    public List<Cliente> findAll(String... orderByColumns){
        return listAll(Sort.descending(orderByColumns)).stream().toList();
    }

    public List<Cliente> search(final String field, final String value){
        final String searchInput = "%" + value.toLowerCase() + "%";
        return list("LOWER(" + field + ") like ?1", searchInput.toLowerCase());
    }

    public List<Cliente> findBy(final String customerId){
        return list("Cliente like ?1", customerId);
    }


}
