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
@Table(name = "tUtilizadores") //, schema = "sql7509759")
public class Utilizador extends BaseEntity {
    @Id
    private String Mail;

    @Column(name = "IdUtilizador")
    private String id;
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

    @OneToMany(fetch = FetchType.LAZY) //, mappedBy = "Client")
    private List<Cargo> cargoList;
    @OneToMany(fetch = FetchType.LAZY) //, mappedBy = "Client")
    private List<Receipt> receiptList;

}
