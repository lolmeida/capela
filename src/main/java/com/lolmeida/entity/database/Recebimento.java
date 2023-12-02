package com.lolmeida.entity.database;


import com.lolmeida.Utils;
import com.lolmeida.entity.BaseEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;


@Data
@Slf4j
@Builder
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "tRecebimentos") //, schema = "sql7509759")
public class Recebimento extends BaseEntity {
    @Id
    private String Chave;

    private String Outros;
    private String ValorPago;


    @ManyToOne
    @JoinColumn(name = "Guia")
    private Carga Guia;

    @OneToOne
    @JoinColumn(name = "Cliente")
    private Cliente Cliente;


}
