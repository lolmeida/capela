package com.lolmeida.entity.database;


import com.lolmeida.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;


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

    @ManyToOne() //cascade = CascadeType.MERGE)
    @JoinColumn(name = "Client")
    private Client client;

    @ManyToOne() //cascade = CascadeType.MERGE)
    @JoinColumn(name = "Destinatario")
    private Client recipient;

    @OneToMany() //fetch = FetchType.LAZY, cascade = CascadeType.MERGE) //, mappedBy = "Client")
    @Column(name = "IdDimensoes")
    private List<Size> sizeList;

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


}
