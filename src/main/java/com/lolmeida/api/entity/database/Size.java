package com.lolmeida.api.entity.database;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;

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
//@Table(name = "tDimensoes", schema = Schema.DB)
public class Size extends BaseEntity {


    String cargoId;
    @Column(name = "Vol")
    private int volume;
    @Column(name = "Comprimento")
    private double length;
    @Column(name = "Altura")
    private double height;
    @Column(name = "Largura")
    private double width;
}
