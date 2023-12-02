package com.lolmeida.repository;

import com.lolmeida.PeahRepository;
import com.lolmeida.entity.database.Cliente;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import io.quarkus.panache.common.Sort;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.UUID;

@ApplicationScoped
public class ClientePeahRepository implements PanacheRepositoryBase<Cliente, UUID> , PeahRepository<Cliente> {
    @Override
    public List<Cliente> findAll(String... orderByColumns){
        return listAll(Sort.descending(orderByColumns)).stream().toList();
    }
    @Override
    public List<Cliente> search(final String field, final String value){
        final String searchInput = "%" + value.toLowerCase() + "%";
        return list("LOWER(" + field + ") like ?1", searchInput.toLowerCase());
    }
    @Override
    public List<Cliente> findBy(final String customerId){
        return list("Cliente like ?1", customerId);
    }

    @Override
    @Transactional
    public String save(Cliente entity) {
        persistAndFlush(entity);
        return entity.getIdCliente();
    }


}
