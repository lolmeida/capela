package com.lolmeida.entity.database;


import com.lolmeida.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;


@Data
@Slf4j
@Builder
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "tClientes") //, schema = "sql7509759")
public class Client extends BaseEntity {
    @Id
    private String id;
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

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    private List<Cargo> cargoList;
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    private List<Receipt> receiptList;

}
