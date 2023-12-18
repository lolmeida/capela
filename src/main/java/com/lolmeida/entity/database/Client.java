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
@Table(name = "tClientes") //, schema = "sql7509759")
public class Client extends BaseEntity {
    @Id
    private String id;


    private String name;


    private String phoneNumber;


    private String address;


    private String type;


    private String email;


    private String user;


    private List<String> cargoList;


    private List<String> receiptList;

}
