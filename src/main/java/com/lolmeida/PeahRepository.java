package com.lolmeida;

import io.smallrye.common.constraint.NotNull;

import java.util.List;

public interface PeahRepository<T> {
    List<T> findAll(String... orderByColumns);

     List<T> search(@NotNull final String field, @NotNull final String value);

    //List<T> searchOpt(final Map<String,String>... fieldsAndValues);

     List<T> findBy(@NotNull final String id);
     String save(T entity);

}
