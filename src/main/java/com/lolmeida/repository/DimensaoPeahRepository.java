package com.lolmeida.repository;

import com.lolmeida.PeahRepository;
import com.lolmeida.entity.database.Dimensao;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import io.quarkus.panache.common.Sort;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.UUID;

@ApplicationScoped
public class DimensaoPeahRepository implements PanacheRepositoryBase<Dimensao, UUID> , PeahRepository<Dimensao> {
    @Override
    public List<Dimensao> findAll(String... orderByColumns){
        return listAll(Sort.descending(orderByColumns)).stream().toList();
    }
    @Override
    public List<Dimensao> search(final String field, final String value){
        final String searchInput = "%" + value.toLowerCase() + "%";
        return list("LOWER(" + field + ") like ?1", searchInput.toLowerCase());
    }



    @Override
    @Transactional
    public String  save(Dimensao entity){
        persistAndFlush(entity);
        return entity.getIdDimensoes();
    }

    @Override
    public List<Dimensao> findBy(final String cargoId){
        return list("Carga like ?1", cargoId);
    }





}
