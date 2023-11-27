package com.lolmeida.dto.request;

import com.lolmeida.entity.database.Cliente;

import java.time.LocalDateTime;
import java.util.UUID;

public record CargaRequest(

        LocalDateTime Data,
        String IdRegisto,
        UUID Guia,
        com.lolmeida.entity.database.Cliente Cliente,
        Cliente Destinatario,
        double vReceber,
        String ListaArnaud,
        String CodigoDespacho,
        String ListaEnvio,
        String IdDimensoes,
        String Status,
        String Tipo,
        String BL,
        String Foto,
        String Nota,
        String Utilizador,
        String Descricao,
        double M3Arnaud,
        double EURM3,
        double EURM3Arnaud,
        double Peso,
        double Valor,
        int Quantidade,
        int Counter,
        boolean Confiavel
) {
}
