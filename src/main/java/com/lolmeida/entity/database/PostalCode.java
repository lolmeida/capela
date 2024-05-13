package com.lolmeida.entity.database;


import com.lolmeida.entity.BaseEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;
import lombok.extern.slf4j.Slf4j;


@Getter
@Setter
@Slf4j
@Builder
@NoArgsConstructor
@AllArgsConstructor

@Entity
//@Table(name = "tCodigoPostal") //, schema = "sql7509759")
public class PostalCode extends BaseEntity {


    @NotEmpty(message = "this is a field is mandatory.")
    @Column(name = "codigo", unique = true, nullable = false, length = 255)
    private String code;

    @Column(name = "Localidade", unique = true, nullable = false, length = 255)
    private String address;
}
