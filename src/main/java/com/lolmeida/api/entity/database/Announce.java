package com.lolmeida.api.entity.database;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import com.lolmeida.api.entity.BaseEntity;


@Getter
@Setter
@Slf4j
@Builder
@NoArgsConstructor
@AllArgsConstructor

@Entity
//@Table(name = "tAnuncios") //, schema = "sql7509759")

public class Announce extends BaseEntity {

    @NotEmpty(message = "this is a field is mandatory.")
    @Column(name = "Tipo",
            unique = true,
            nullable = false,
            length = 255)
    private String type;

    @Column(name = "Título",
            unique = true,
            nullable = false,
            length = 255)
    private String tittle;

    @Column(name = "Url")
    private String url;

}
