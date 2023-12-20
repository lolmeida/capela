package com.lolmeida.entity.database;


import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import com.lolmeida.entity.BaseEntity;


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

