package com.lolmeida.entity.database;


import com.lolmeida.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
    @Column(name = "Nome", unique = true, nullable = false, length = 255)
    private String name;

    @Column(name = "Email", unique = false, nullable = true, length = 255)
    private String email;

    @Column(name = "Contacto")
    private String contact;

}
