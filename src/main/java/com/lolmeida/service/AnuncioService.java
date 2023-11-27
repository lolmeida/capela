package com.lolmeida.service;

import com.lolmeida.Repository;
import com.lolmeida.entity.database.Agente;
import com.lolmeida.entity.database.Anuncio;
import com.lolmeida.repository.AgenteRepository;
import com.lolmeida.repository.AnuncioRepository;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;

import java.util.List;

@RequestScoped
public class AnuncioService implements Repository<Anuncio> {
    @Inject
    AnuncioRepository repository;

    @Override
    public List<Anuncio> findAll(String... orderByColumns){
        return  repository.findAll(orderByColumns);
    }

    @Override
    public List<Anuncio> search(String field, String value) {
        return repository.search(field, value);
    }

    @Override
    public List<Anuncio> findBy(String customerId) {
        return repository.findBy(customerId);
    }
}
