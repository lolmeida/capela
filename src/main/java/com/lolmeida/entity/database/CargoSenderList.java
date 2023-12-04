package com.lolmeida.entity.database;


import com.lolmeida.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.util.List;


@Getter
@Setter
@Slf4j
@Builder
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "tListaEnvio") //, schema = "sql7509759")
public class CargoSenderList extends BaseEntity {

    @Id
    @Column(name = "IdLista")
    private String id;

    @Column(name = "Qtd", columnDefinition = "INT DEFAULT 1")
    private int quantity;

    @Column(name = "NumfaturaArnaud")
    private String numInvoiceArnaud;

    @Column(name = "DtFacturaArnaud")
    private LocalDateTime dateInvoiceArnaud;

    @Column(name = "ValorFaturaArnaud")
    private double valueInvoiceArnaud;

    @Column(name = "Agente")
    private String agent;

    @Column(name = "DataChegada")
    private LocalDateTime arrivedDate;

    @Column(name = "Para")
    private String to;


    @OneToMany(fetch = FetchType.LAZY) //, mappedBy = "Client")
    List<Cargo> cargoList;
}
