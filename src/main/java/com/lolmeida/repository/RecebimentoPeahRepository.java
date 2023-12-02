package com.lolmeida.repository;

import com.lolmeida.PeahRepository;
import com.lolmeida.entity.database.Dimensao;
import com.lolmeida.entity.database.Recebimento;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import io.quarkus.panache.common.Sort;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.UUID;

@ApplicationScoped
public class RecebimentoPeahRepository implements PanacheRepositoryBase<Recebimento, UUID>, PeahRepository<Recebimento> {
    public List<Recebimento> findAll(String... orderByColumns){
        return listAll(Sort.descending(orderByColumns)).stream().toList();
    }

    public List<Recebimento> search(final String field, final String value){
        final String searchInput = "%" + value.toLowerCase() + "%";
        return list("LOWER(" + field + ") like ?1", searchInput.toLowerCase());
    }
    @Override
    public List<Recebimento> findBy(final String customerId){
        return list("Cliente like ?1", customerId);
    }

    @Override
    @Transactional
    public String save(Recebimento entity) {
        persistAndFlush(entity);
        return entity.getChave();
    }


}
