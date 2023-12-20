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
@Table(name = "tUtilizadores") //, schema = "sql7509759")
public class User extends BaseEntity {
    @Id
    private String id;

    private String email;

    private String name;

    private String phoneNumber;

    private String address;

    private String signature;

    private String privilege;

    private String permission;



    private List<String> cargoList;
    private List<String> receiptList;
    private List<String> clientList;
    private List<String> recipientList;
    private List<String> sizeList;

}
