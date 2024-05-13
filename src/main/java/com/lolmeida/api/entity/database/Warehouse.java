package com.lolmeida.api.entity.database;


import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotEmpty;

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
//@Table(name = "tArmazem", schema = Schema.DB)
public class Warehouse extends BaseEntity {

    @NotEmpty(message = "this is a field is mandatory.")
    @Column(name = "Armazem",
            unique = true,
            nullable = false,
            length = 25)
    private String name;

    @Column(name = "Morada",
            unique = false,
            nullable = false,
            length = 125)
    private String address;

    @Column(name = "Telefone",
            unique = false,
            length = 25)
    private String phoneNumber;

    @OneToMany
    private List<Cargo> cargoList;
}
