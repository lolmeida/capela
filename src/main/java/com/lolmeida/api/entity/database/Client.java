package com.lolmeida.api.entity.database;


import com.lolmeida.api.entity.BaseEntity;

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
//@Table(name = "tClientes") //, schema = "sql7509759")
public class Client extends BaseEntity {


    @Column(name = "Client",nullable = false)
    private String name;

    @Column(name = "Telefone",nullable = true)
    private String phoneNumber;

    @Column(name = "Morada",nullable = true)
    private String address;

    @Column(name = "Tipo",nullable = false) 
    private String type;

    @Column(name = "Email",nullable = false)
    private String email;

    @OneToMany
    private List<Cargo> cargoList;

    @OneToMany
    private List<Receipt> receiptList;

}