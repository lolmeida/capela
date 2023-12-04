package com.lolmeida.entity.database;


import com.lolmeida.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Set;


@Data
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



    @Column(name = "Cliente")
    private String clientId;


    @Column(name = "Destinatario")
    private String recipientId;




    private List<String> sizeList;


}
