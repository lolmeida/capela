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
    private String id;

    private double otherAmount;

    private double amount;


    private String client;


    private String user;


    private List<String> cargoList;

}

