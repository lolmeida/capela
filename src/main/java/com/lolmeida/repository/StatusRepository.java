package com.lolmeida.repository;

import com.lolmeida.Repository;
import com.lolmeida.entity.database.App;
import com.lolmeida.entity.database.Status;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import io.quarkus.panache.common.Sort;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;
import java.util.UUID;

@ApplicationScoped
public class StatusRepository implements PanacheRepositoryBase<Status, UUID>, Repository<Status> {

    @Override
    public List<Status> findAll(String... orderByColumns) {
        return listAll(Sort.descending(orderByColumns)).stream().toList();
    }

    @Override
    public List<Status> search(String field, String value) {
        final String searchInput = "%" + value.toLowerCase() + "%";
        return list("LOWER(" + field + ") like ?1", searchInput.toLowerCase());
    }

    @Override
    public List<Status> findBy(String tipo) {
        return list("Tipo like ?1", tipo);
    }
}
