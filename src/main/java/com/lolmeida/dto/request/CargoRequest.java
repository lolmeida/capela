package com.lolmeida.dto.request;

import com.lolmeida.entity.database.Cargo;
import com.lolmeida.entity.database.Client;
import com.lolmeida.entity.database.Size;

import java.util.List;
import java.util.Set;

public record CargoRequest(
        String cargoNumber,
        Client client,
        Client recipient,
        double total,
        List<Size> sizeList,
        String status,
        Cargo cargo

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
