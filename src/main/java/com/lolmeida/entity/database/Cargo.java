package com.lolmeida.entity.database;


import com.lolmeida.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Set;


@Getter
@Setter
@Slf4j
@Builder
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "tCargas") //, schema = "sql7509759")
public class Cargo extends BaseEntity {

    @Column(name = "IdRegisto")
    private String id;
    @Id
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

    @Column(name = "Quantidade",  columnDefinition = "INT DEFAULT 1")
    private int quantity;

    @OneToOne
    @JoinColumn(name = "client_id")
    private Client client;


    @OneToOne
    @JoinColumn(name = "recipient_id")
    private Client recipient;


    @ManyToOne
    @JoinColumn(name = "receipt_chave")
    private Receipt receipt;

    @OneToMany
    private List<Size> sizeList;
}
