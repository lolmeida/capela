package com.lolmeida.entity.database;


import com.lolmeida.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.UUID;


@Data
@Slf4j
@Builder
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "tDimensoes") //, schema = "sql7509759")
public class Dimensao extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID IdDimensoes;
    //@ManyToOne
    //@JoinColumn(name = "Guia")
    private String Guia;

    //@NotEmpty(message = "this is a field is mandatory.")
    //@Column(unique = false, nullable = false, length = 255)
    private int Vol;
    private double Comprimento;
    private double Altura;
    private double Largura;
    //private String Nota;
    //private String Foto;
    //private String UserMail;
}
