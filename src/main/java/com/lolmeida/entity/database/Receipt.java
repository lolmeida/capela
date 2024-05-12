package com.lolmeida.entity.database;


import com.lolmeida.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

import java.util.List;


@Getter
@Setter
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



    //@ManyToOne
    //@JoinColumn(name = "cargoNumber")
    private String cargo;

    //@ManyToOne
    //@JoinColumn(name = "clientId")
    private String client;

    //@OneToMany(mappedBy = "cargoNumber", fetch = FetchType.LAZY)
    private List<String> sizeList;

}
