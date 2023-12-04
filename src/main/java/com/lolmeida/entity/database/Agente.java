package com.lolmeida.entity.database;


import com.lolmeida.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
@Table(name = "tAgente") //, schema = "sql7509759")
public class Agente extends BaseEntity {

    @Id
    private String Id;

    @NotEmpty(message = "this is a field is mandatory.")
    @Column(name = "Nome", unique = true, nullable = false)
    private String name;

    @Column(name = "Email")
    private String email;

    @Column(name = "Contacto")
    private String contact;

}
