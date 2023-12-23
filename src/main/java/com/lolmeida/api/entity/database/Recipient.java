package com.lolmeida.api.entity.database;


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

import com.lolmeida.api.entity.BaseEntity;


@Getter
@Setter
@Slf4j
@Builder
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "tDestinatario") //, schema = "sql7509759")
public class Recipient extends BaseEntity {
    @Id
    private String id;


    private String name;


    private String phoneNumber;


    private String address;


    private String type;


    private String email;


    private String user;


    private List<String> cargoList;


}
