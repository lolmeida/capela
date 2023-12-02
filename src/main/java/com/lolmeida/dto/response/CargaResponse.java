package com.lolmeida.dto.response;


import com.lolmeida.entity.database.Cliente;
import com.lolmeida.entity.database.Dimensao;
import lombok.Builder;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
@Builder
public record CargaResponse(

    //LocalDateTime Data,
    //String IdRegisto,
    String Guia,
    Cliente Cliente,
    Cliente Destinatario,
    double vReceber,
    List<Dimensao> Dimensoes,
    String Status,

    /*
    String ListaArnaud,
    String CodigoDespacho,
    String ListaEnvio,
    String Tipo,
    String BL,
    double M3Arnaud,
    double EURM3,
    double EURM3Arnaud,
    double Peso,
    double Valor,
    int Quantidade,
    boolean Confiavel
     */

    // BaseEntity
    String Id,
    String UserEmail,
    String ModificadoPor,
    boolean Activo,
    String Nota,
    String Anexo,
    String Utilizador,
    String Foto,
    String Descricao,
    Long createdTime,
    Long updatedTime,
    LocalDateTime Data,
    LocalDateTime createdAt,
    LocalDateTime updatedAt
) {
}
