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
//@Table(name = "tCodigoPostal", schema = Schema.DB)
public class PostalCode extends BaseEntity {


    @NotEmpty(message = "this is a field is mandatory.")
    @Column(name = "codigo",
            unique = true,
            nullable = false,
            length = 255)
    private String code;

    @Column(name = "Localidade",
            unique = true,
            nullable = false,
            length = 255)
    private String address;
}
