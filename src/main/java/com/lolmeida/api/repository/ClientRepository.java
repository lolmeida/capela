package com.lolmeida.api.repository;


import com.lolmeida.api.entity.database.Client;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import io.quarkus.panache.common.Sort;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.UUID;

@ApplicationScoped
public class ClientRepository implements PanacheRepositoryBase<Client, UUID> , PeahRepository<Client> {
    @Override
    public List<Client> findAll(String... orderByColumns){
        return listAll(Sort.descending(orderByColumns)).stream().toList();
    }
    @Override
    public List<Client> search(final String field, final String value){
        final String searchInput = "%" + value.toLowerCase() + "%";
        return list("LOWER(" + field + ") like ?1", searchInput.toLowerCase());
    }
    @Override
    public List<Client> findBy(final String id){
        return list("Client like ?1", id);
    }

    @Override
    @Transactional
    public String save(Client entity) {
        persistAndFlush(entity);
        return entity.getId();
    }


}
