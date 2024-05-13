package com.lolmeida.api.entity.database;


import com.lolmeida.api.entity.BaseEntity;

import jakarta.persistence.*;
import lombok.*;
import lombok.extern.slf4j.Slf4j;


@Getter
@Setter
@Slf4j
@Builder
@NoArgsConstructor
@AllArgsConstructor

@Entity
//@Table(name = "tDimensoes") //, schema = "sql7509759")
public class Size extends BaseEntity {



    @Column(name = "Vol")
    private int volume;

    @Column(name = "Comprimento")
    private double length;

    @Column(name = "Altura")
    private double height;

    @Column(name = "Largura")
    private double width;


    @ManyToOne
    @JoinColumn(name = "cargo_id")
    private Cargo cargo;
}
