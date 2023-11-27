package com.lolmeida.entity.database;


import com.lolmeida.entity.BaseEntity;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.util.UUID;


@Data
@Slf4j
@Builder
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "tCargas") //, schema = "sql7509759")
public class Carga extends BaseEntity {
    
    private String IdRegisto;
    //@NotEmpty(message = "this is a field is mandatory.")
    //@Column(unique = true, nullable = true, length = 255)
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID Guia;

    @ManyToOne
    @JoinColumn(name = "Cliente")
    private Cliente Cliente;

    @ManyToOne
    @JoinColumn(name = "Destinatario")
    private Cliente Destinatario;

    @ManyToOne
    @JoinColumn(name = "IdDimensoes")
    private Dimensao IdDimensoes;

    @ManyToOne
    @JoinColumn(name = "Utilizador")
    private Utilizador Utilizador;

    private String ListaArnaud;
    private String CodigoDespacho;
    private String ListaEnvio;
    private String Status;
    private String Tipo;
    private String BL;
    private String Foto;
    private String Nota;
    private String Descricao;
    private LocalDateTime Data;
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
