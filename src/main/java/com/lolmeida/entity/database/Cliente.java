package com.lolmeida.entity.database;


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
    //@NotEmpty(message = "this is a field is mandatory.")
    //@Column(unique = true, nullable = false, length = 255)
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID IdCliente;
    private String Cliente;
    private String Telefone;
    private String Morada;
    private String Tipo;
    private String Email;
    private String Nota;
    private String Data;

    @OneToMany(fetch = FetchType.EAGER) //, mappedBy = "Cliente")
    private List<Carga> cargas;
    @OneToMany(fetch = FetchType.LAZY) //, mappedBy = "Cliente")
    private List<Recebimento> recebimentos;

}
