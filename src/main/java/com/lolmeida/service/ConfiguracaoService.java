package com.lolmeida.service;

import com.lolmeida.PeahRepository;
import com.lolmeida.entity.database.Configuracao;
import com.lolmeida.repository.ConfiguracaoPeahRepository;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;

import java.util.List;

@RequestScoped
public class ConfiguracaoService implements PeahRepository<Configuracao> {
    @Inject
    ConfiguracaoPeahRepository repository;

    @Override
    public List<Configuracao> findAll(String... orderByColumns){
        return  repository.findAll(orderByColumns);
    }

    @Override
    public List<Configuracao> search(String field, String value) {
        return repository.search(field, value);
    }

    @Override
    public List<Configuracao> findBy(String customerId) {
        return repository.findBy(customerId);
    }

    @Override
    public String save(Configuracao entity) {
        return repository.save(entity);
    }
}
