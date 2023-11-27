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
import java.util.List;
import java.util.UUID;


@Data
@Slf4j
@Builder
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "tListaEnvio") //, schema = "sql7509759")
public class Lista extends BaseEntity {
    //@NotEmpty(message = "this is a field is mandatory.")
    //@Column(unique = true, nullable = false, length = 255)
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID IdLista;
    private int Qtd;
    private String NumfaturaArnaud;
    private LocalDateTime DtFacturaArnaud;
    private double ValorFaturaArnaud;
    private String Agente;
    private LocalDateTime DataChegada;
    private String Para;
    //private String Observações;
    //private LocalDateTime DateTime;
    //private String Data;
    //private String Utilizador;

    @OneToMany(fetch = FetchType.LAZY) //, mappedBy = "Cliente")
    List<Carga> cargas;
}
