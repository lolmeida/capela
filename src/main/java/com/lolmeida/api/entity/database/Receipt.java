package com.lolmeida.api.entity.database;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

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
