package com.lolmeida.entity.database;


import com.lolmeida.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;
import lombok.extern.slf4j.Slf4j;


@Getter
@Setter
@Slf4j
@Builder
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "tDimensoes") //, schema = "sql7509759")
public class Size extends BaseEntity {

    @Id
    @Column(name = "IdDimensoes")
    private String id;

    @Column(name = "Vol")
    private int volume;

    @Column(name = "Comprimento")
    private double length;

    @Column(name = "Altura")
    private double height;

    @Column(name = "Largura")
    private double width;


    //@ManyToOne(fetch = FetchType.LAZY)
    //@JoinColumn(name = "cargoNumber")
    private String cargo;
}
