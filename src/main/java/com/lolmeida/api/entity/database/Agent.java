package com.lolmeida.api.entity.database;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import com.lolmeida.api.AppConfig.Schema;
import com.lolmeida.api.entity.BaseEntity;


@Getter
@Setter
@Slf4j
@Builder
@NoArgsConstructor
@AllArgsConstructor

@Entity
//@Table(name = Schema.Table.AGENT, schema = Schema.DB)
public class Agent extends BaseEntity {

    @NotEmpty(message = "this is a field is mandatory.")
    @Column(name = "Nome",
            nullable = false)
    private String name;

    @Column(name = "Email",
            nullable = false)
    private String email;

    @Column(name = "Contacto")
    private String contact;

}
