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
import com.lolmeida.entity.CargoStatus;


@Getter
@Setter
@Slf4j
@Builder
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "tCargas") //, schema = "sql7509759")
public class Cargo extends BaseEntity {


    @Id
    private String id;

    private String cargoNumber;

    private String arnaudListId;


    private String dispatchCode;


    private String sendListId;


    private CargoStatus status;


    private String type;


    private String billOfLanding;


    private double total;


    private double arnaudUnitPriceInM3;


    private double unitPriceInM3;


    private double arnaudTotalPrice;


    private double weight;


    private double amount;


    private int quantity;




    private String client;
    private String recipient;
    private String user;



    private List<String> sizeList;


    private String receipt;

}
