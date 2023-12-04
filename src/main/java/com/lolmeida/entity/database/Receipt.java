package com.lolmeida.entity.database;


import com.lolmeida.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@Data
@Slf4j
@Builder
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "tRecebimentos") //, schema = "sql7509759")
public class Receipt extends BaseEntity {
    @Id
    @Column(name = "Chave")
    private String id;

    @Column(name = "Outros")
    private double otherAmount;

    @Column(name = "ValorPago")
    private double amount;



    @Column(name = "Carga")
    private String cargoNumber;

    @Column(name = "Client")
    private String clientId;

}
