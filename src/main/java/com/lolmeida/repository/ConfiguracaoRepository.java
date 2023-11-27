package com.lolmeida.repository;

import com.lolmeida.Repository;
import com.lolmeida.entity.database.App;
import com.lolmeida.entity.database.Configuracao;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import io.quarkus.panache.common.Sort;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;
import java.util.UUID;

@ApplicationScoped
public class ConfiguracaoRepository implements PanacheRepositoryBase<Configuracao, UUID>, Repository<Configuracao> {

    @Override
    public List<Configuracao> findAll(String... orderByColumns) {
        return listAll(Sort.descending(orderByColumns)).stream().toList();
    }

    @Override
    public List<Configuracao> search(String field, String value) {
        final String searchInput = "%" + value.toLowerCase() + "%";
        return list("LOWER(" + field + ") like ?1", searchInput.toLowerCase());
    }

    @Override
    public List<Configuracao> findBy(String nome) {
        return list("appName like ?1", nome);
    }
}
