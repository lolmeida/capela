package com.lolmeida.api.entity.database;


import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

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
//@Table(name = "tListaEnvio") //, schema = "sql7509759")
public class CargoSenderList extends BaseEntity {


    @OneToMany
    List<Cargo> cargoList;
    @Column(name = "Qtd",
            columnDefinition = "INT DEFAULT 1")
    private int quantity;
    @Column(name = "NumfaturaArnaud")
    private String numInvoiceArnaud;
    @Column(name = "DtFacturaArnaud")
    private LocalDateTime dateInvoiceArnaud;
    @Column(name = "ValorFaturaArnaud")
    private double valueInvoiceArnaud;
    @Column(name = "Agent")
    private String agent;
    @Column(name = "DataChegada")
    private LocalDateTime arrivedDate;
    @Column(name = "Para")
    private String to;
}
