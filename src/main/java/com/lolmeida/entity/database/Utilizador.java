package com.lolmeida.entity.database;


import com.lolmeida.entity.BaseEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
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
@Table(name = "tUtilizadores") //, schema = "sql7509759")
public class Utilizador extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String IdUtilizador;

    //@NotEmpty(message = "this is a field is mandatory.")
    //@Column(unique = true, nullable = false, length = 255)
    private String Mail;

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
    //private String Foto;
    //private String Anexo;
    //private String Nota;
    //private String Utilizador;
    //private LocalDateTime Data;
}
