package com.lolmeida.entity.database;


import com.lolmeida.Utils;
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
@Table(name = "tCargas") //, schema = "sql7509759")
public class Carga extends BaseEntity {

    private String IdRegisto;
    @Id
    private String Guia;

    @ManyToOne//(fetch = FetchType.LAZY)
    @JoinColumn(name = "Cliente")
    private Cliente Cliente;

    @ManyToOne//(fetch = FetchType.LAZY)
    @JoinColumn(name = "Destinatario")
    private Cliente Destinatario;
    private String IdDimensoes;
    private String Utilizador;
    private String ListaArnaud;
    private String CodigoDespacho;
    private String ListaEnvio;
    private String Status;
    private String Tipo;
    private String BL;
    private double vReceber;
    private double M3Arnaud;
    private double EURM3;
    private double EURM3Arnaud;
    private double Peso;
    private double Valor;
    private int Quantidade;
    private int Counter;
    private boolean Confiavel;

}
