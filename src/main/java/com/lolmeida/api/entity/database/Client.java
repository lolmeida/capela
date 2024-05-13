package com.lolmeida.api.entity.database;


import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

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
//@Table(name = "tClientes") //, schema = "sql7509759")
public class Client extends BaseEntity {


    @Column(name = "Client",
            nullable = false)
    private String name;

    @Column(name = "Telefone",
            nullable = true)
    private String phoneNumber;

    @Column(name = "Morada",
            nullable = true)
    private String address;

    @Column(name = "Tipo",
            nullable = false)
    private String type;

    @Column(name = "Email",
            nullable = false)
    private String email;

    @OneToMany
    private List<Cargo> cargoList;

    @OneToMany
    private List<Receipt> receiptList;

}
