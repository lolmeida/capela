package com.lolmeida;

import com.lolmeida.entity.database.Carga;

import java.util.List;

public interface Repository<T> {
    public List<T> findAll(String... orderByColumns);
    public List<T> search(final String field, final String value);
    public List<T> findBy(final String customerId);
}
