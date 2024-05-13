package com.lolmeida.api.entity.database;


import java.util.List;

import jakarta.persistence.Entity;

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
//@Table(name = "tUtilizadores", schema = Schema.DB)
public class Utilizador extends BaseEntity {


    private String mail;
    private String Nome;
    private String Telefone;
    private String Morada;
    private String Assinatura;
    private String Previlegio;
    private String Perfil;
    private String Clientes;
    private String Recebimentos;
    private String Cargas;
    private String DiasEdicaoDocumento;
    private String PrazoAnularEstadoDias;
    private String DiasEliminarDocumento;
    private String QtdMaxFactDivida;
    private String DiasMaxFactDivida;
    private String HojeMenosData;


    private List<String> cargoList;


    private List<String> receiptList;

}
