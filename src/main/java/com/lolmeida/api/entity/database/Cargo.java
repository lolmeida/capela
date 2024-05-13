package com.lolmeida.api.entity.database;


import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
//@Table(name = "tCargas", schema = Schema.DB)

public class Cargo extends BaseEntity {


    @Column(name = "Guia")
    private String cargoNumber;

    @Column(name = "ListaArnaud")
    private String arnaudListId;

    @Column(name = "CodigoDespacho")
    private String dispatchCode;

    @Column(name = "ListaEnvio")
    private String sendListId;

    @Column(name = "Status")
    private String status;

    @Column(name = "Tipo")
    private String type;

    @Column(name = "BL")
    private String billOfLanding;

    @Column(name = "vReceber")
    private double total;

    @Column(name = "M3Arnaud")
    private double arnaudUnitPriceInM3;

    @Column(name = "EURM3")
    private double unitPriceInM3;

    @Column(name = "EURM3Arnaud")
    private double arnaudTotalPrice;

    @Column(name = "Peso")
    private double weight;

    @Column(name = "Valor")
    private double amount;

    @Column(name = "Quantidade",
            columnDefinition = "INT DEFAULT 1")
    private int quantity;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @ManyToOne
    @JoinColumn(name = "recipient_id")
    private Client recipient;

    @ManyToOne
    @JoinColumn(name = "warehouse_id")
    private Warehouse warehouse;

    @ManyToOne
    @JoinColumn(name = "receipt_id")
    private Receipt receipt;

    @ManyToOne
    @JoinColumn(name = "status_id")
    private Status statusId;

    @OneToMany
    private List<Size> sizeList;
}
