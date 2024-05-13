package com.lolmeida.api;

import java.util.List;

import jakarta.transaction.Transactional;

public interface RepositoryApi<T> {

    List<T> findAll(String... orderByColumns);

    List<T> search(final String field, final String value);

    //public List<T> searchOpt(final Map<String,String>... fieldsAndValues);

    T findBy(final String id);

    String save(T entity);
}
