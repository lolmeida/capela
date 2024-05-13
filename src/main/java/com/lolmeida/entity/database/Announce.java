package com.lolmeida.entity.database;


import com.lolmeida.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
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
//@Table(name = "tAnuncios") //, schema = "sql7509759")

public class Announce extends BaseEntity {

    @NotEmpty(message = "this is a field is mandatory.")
    @Column(name = "Tipo", unique = true, nullable = false, length = 255)
    private String type;

    @Column(name = "Título", unique = true, nullable = false, length = 255)
    private String tittle;

    @Column(name = "Url")
    private String url;

}
