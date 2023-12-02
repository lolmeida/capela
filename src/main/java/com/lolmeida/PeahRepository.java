package com.lolmeida;

import jakarta.transaction.Transactional;

import java.util.List;

public interface PeahRepository<T> {
    public List<T> findAll(String... orderByColumns);

    public List<T> search(final String field, final String value);

    public List<T> findBy(final String customerId);
    public String save(T entity);

}
