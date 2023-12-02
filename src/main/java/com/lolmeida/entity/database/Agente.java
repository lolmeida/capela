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


@Data
@Slf4j
@Builder
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "tAgente") //, schema = "sql7509759")
public class Agente extends BaseEntity {

    @Id
    private String Id;

    @NotEmpty(message = "this is a field is mandatory.")
    @Column(unique = true, nullable = true, length = 255)
    private String Nome;
    private String Email;
    private String Contacto;

}
