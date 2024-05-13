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
//@Table(name = "tRecebimentos") //, schema = "sql7509759")
public class Receipt extends BaseEntity {


    @Column(name = "Outros")
    private double otherAmount;

    @Column(name = "ValorPago")
    private double amount;



    @ManyToOne
    @JoinColumn(name = "cargo_id")
    private Cargo cargo;


    @OneToOne
    @JoinColumn(name = "client_id")
    private Client client;


}