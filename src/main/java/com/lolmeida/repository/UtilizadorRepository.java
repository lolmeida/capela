package com.lolmeida.repository;

import com.lolmeida.Repository;
import com.lolmeida.entity.database.Utilizador;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import io.quarkus.panache.common.Sort;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;
import java.util.UUID;

@ApplicationScoped
public class UtilizadorRepository implements PanacheRepositoryBase<Utilizador, UUID>, Repository<Utilizador> {
    public List<Utilizador> findAll(String... orderByColumns){
        return listAll(Sort.descending(orderByColumns)).stream().toList();
    }

    public List<Utilizador> search(final String field, final String value){
        final String searchInput = "%" + value.toLowerCase() + "%";
        return list("LOWER(" + field + ") like ?1", searchInput.toLowerCase());
    }

    public List<Utilizador> findByCustomer(String customerId) {
        return null;
    }

    public List<Utilizador> findBy(final String id){
        return list("Mail like ?1", id);
    }

}
