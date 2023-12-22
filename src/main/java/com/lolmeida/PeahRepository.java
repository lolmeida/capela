package com.lolmeida;

import java.util.List;

import io.smallrye.common.constraint.NotNull;

public interface PeahRepository<T> {
    List<T> findAll(final String... orderByColumns);

     List<T> search(@NotNull final String field, @NotNull final String value);

    //List<T> searchOpt(final Map<String,String>... fieldsAndValues);

     List<T> findBy(@NotNull final String id);
     String save(T entity);

}
