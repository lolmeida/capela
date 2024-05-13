package com.lolmeida.api.dto.request;

import java.util.List;

import com.lolmeida.api.entity.database.Client;
import com.lolmeida.api.entity.database.Size;

public record CargoRequest(
        String cargoNumber,
        Client client,
        Client recipient,
        double total,
        List<Size> sizeList,
        String status

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
