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
@Table(name = "tCargas") //, schema = "sql7509759")
public class Cargo extends BaseEntity {


    @Id
    private String id;

    private String cargoNumber;

    private String arnaudListId;


    private String dispatchCode;


    private String sendListId;


    private String status;


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
