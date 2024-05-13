package com.lolmeida.api.entity.database;


import com.lolmeida.api.entity.BaseEntity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;
import lombok.extern.slf4j.Slf4j;


@Getter
@Setter
@Slf4j
@Builder
@NoArgsConstructor
@AllArgsConstructor

@Entity
//@Table(name = "tConfiguracoes") //, schema = "sql7509759")
public class Configuration extends BaseEntity {

    @NotEmpty(message = "this is a field is mandatory.")
    @Column(name = "Parametro", unique = true, nullable = false, length = 255)
    private String key;

    @Column(name = "Valor", nullable = false, length = 255)
    private String value;

    @Column(name = "Texto")
    private String description;

}
