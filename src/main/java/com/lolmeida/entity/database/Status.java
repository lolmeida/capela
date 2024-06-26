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
@Table(name = "tIdStatus") //, schema = "sql7509759")
public class Status extends BaseEntity {
    @Id
    private String id;

    @NotEmpty(message = "this is a field is mandatory.")
    @Column(name = "Status",unique = true, nullable = false, length = 255)
    private String status;

    @Column(name = "Qtd")
    private int quantity;

    @Column(name = "Formula")
    private String formula;

    @Column(name = "Tipo")
    private String type;

}
