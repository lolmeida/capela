package com.lolmeida.entity.database;


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
@Table(name = "tArmazem") //, schema = "sql7509759")
public class Warehouse extends BaseEntity {

    @Id
    private String id;

    @NotEmpty(message = "this is a field is mandatory.")
    @Column(name = "Armazem",unique = true, nullable = false, length = 25)
    private String name;

    @Column(name = "Morada",unique = false, nullable = false, length = 125)
    private String address;

    @Column(name = "Teletofe",unique = false, nullable = true, length = 25)
    private String phoneNumber;
}
