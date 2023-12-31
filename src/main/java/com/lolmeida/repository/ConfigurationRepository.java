package com.lolmeida.repository;

import com.lolmeida.PeahRepository;
import com.lolmeida.entity.database.Configuration;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import io.quarkus.panache.common.Sort;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.UUID;

@ApplicationScoped
public class ConfigurationRepository implements PanacheRepositoryBase<Configuration, UUID>, PeahRepository<Configuration> {

    @Override
    public List<Configuration> findAll(String... orderByColumns) {
        return listAll(Sort.descending(orderByColumns)).stream().toList();
    }

    @Override
    public List<Configuration> search(String field, String value) {
        final String searchInput = "%" + value.toLowerCase() + "%";
        return list("LOWER(" + field + ") like ?1", searchInput.toLowerCase());
    }

    @Override
    public List<Configuration> findBy(String nome) {
        return list("appName like ?1", nome);
    }

    @Override
    @Transactional
    public String save(Configuration entity) {
        persistAndFlush(entity);
        return entity.getId();
    }
}
