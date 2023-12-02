package com.lolmeida.dto.request;

import com.lolmeida.entity.database.Cliente;

import java.time.LocalDateTime;
import java.util.UUID;

public record CargaRequest(
        Cliente Cliente,
        Cliente Destinatario,
        double vReceber,
        String IdDimensoes,
        String Status

        //String Foto,
        //String Nota,
        //String Utilizador,
        //String Descricao

        //LocalDateTime Data,
        //String IdRegisto,
        //UUID Guia,
        //String ListaArnaud,
        //String CodigoDespacho,
        //String ListaEnvio,
        //String Tipo,
        //String BL,
        //double M3Arnaud,
        //double EURM3,
        //double EURM3Arnaud,
        //double Peso,
        //double Valor,
        //int Quantidade,
        //int Counter,
        //boolean Confiavel
) {
}
