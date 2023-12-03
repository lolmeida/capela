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
@Table(name = "tAnuncios") //, schema = "sql7509759")
public class Anuncio extends BaseEntity {
    @Id
    private String id;

    @NotEmpty(message = "this is a field is mandatory.")
    @Column(name = "Tipo", unique = true, nullable = false, length = 255)
    private String type;

    @Column(name = "Título", unique = true, nullable = false, length = 255)
    private String tittle;

    @Column(name = "Url")
    private String url;

}
