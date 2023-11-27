package com.lolmeida.service;

import com.lolmeida.Repository;
import com.lolmeida.entity.database.CodigoPostal;
import com.lolmeida.entity.database.Configuracao;
import com.lolmeida.repository.CodigoPostalRepository;
import com.lolmeida.repository.ConfiguracaoRepository;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;

import java.util.List;

@RequestScoped
public class ConfiguracaoService implements Repository<Configuracao> {
    @Inject
    ConfiguracaoRepository repository;

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
}
