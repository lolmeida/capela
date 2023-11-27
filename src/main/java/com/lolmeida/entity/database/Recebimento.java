package com.lolmeida.entity.database;


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
    @GeneratedValue(strategy = GenerationType.UUID)
    private String Chave;

    private String Outros;
    private String ValorPago;
    private String Data;
    private String Nota;
    private String Anexo;
    private String Foto;
    //private LocalDateTime DateTime;

    //@NotEmpty(message = "this is a field is mandatory.")
    //@Column(unique = true, nullable = false, length = 255)

    @ManyToOne
    @JoinColumn(name = "Guia")
    private Carga Guia;

    @OneToOne
    @JoinColumn(name = "Cliente")
    private Cliente Cliente;

    @ManyToOne
    @JoinColumn(name = "Utilizador")
    private Utilizador Utilizador;

}
