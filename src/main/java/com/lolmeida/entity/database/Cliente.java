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

import java.util.List;
import java.util.UUID;


@Data
@Slf4j
@Builder
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "tClientes") //, schema = "sql7509759")
public class Cliente extends BaseEntity {
    @Id
    private String IdCliente;
    @Column(nullable = false)
    private String Cliente;
    private String Telefone;
    private String Morada;

    @Column(nullable = false) //, columnDefinition = "varchar(255) DEFAULT 'CLI'")
    private String Tipo;
    private String Email;

    @OneToMany(fetch = FetchType.EAGER) //, mappedBy = "Cliente")
    private List<Carga> cargas;
    @OneToMany(fetch = FetchType.LAZY) //, mappedBy = "Cliente")
    private List<Recebimento> recebimentos;

}
