package com.lolmeida.repository;

import com.lolmeida.PeahRepository;
import com.lolmeida.entity.database.Size;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import io.quarkus.panache.common.Sort;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.UUID;

@ApplicationScoped
public class DimensionRepository implements PanacheRepositoryBase<Size, UUID> , PeahRepository<Size> {
    @Override
    public List<Size> findAll(String... orderByColumns){
        return listAll(Sort.descending(orderByColumns)).stream().toList();
    }
    @Override
    public List<Size> search(final String field, final String value){
        final String searchInput = "%" + value.toLowerCase() + "%";
        return list("LOWER(" + field + ") like ?1", searchInput.toLowerCase());
    }



    @Override
    @Transactional
    public String  save(Size entity){
        persistAndFlush(entity);
        return entity.getId();
    }

    @Override
    public List<Size> findBy(final String cargoId){
        return list("cargo like ?1", cargoId);
    }

}
