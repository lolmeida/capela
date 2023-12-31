package com.lolmeida.repository;

import com.lolmeida.PeahRepository;
import com.lolmeida.entity.database.Receipt;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import io.quarkus.panache.common.Sort;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.UUID;

@ApplicationScoped
public class RecebimentoPeahRepository implements PanacheRepositoryBase<Receipt, UUID>, PeahRepository<Receipt> {
    public List<Receipt> findAll(String... orderByColumns){
        return listAll(Sort.descending(orderByColumns)).stream().toList();
    }

    public List<Receipt> search(final String field, final String value){
        final String searchInput = "%" + value.toLowerCase() + "%";
        return list("LOWER(" + field + ") like ?1", searchInput.toLowerCase());
    }
    @Override
    public List<Receipt> findBy(final String id){
        return list("Client like ?1", id);
    }

    @Override
    @Transactional
    public String save(Receipt entity) {
        persistAndFlush(entity);
        return entity.getId();
    }


}
