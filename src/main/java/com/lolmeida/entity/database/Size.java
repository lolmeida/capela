package com.lolmeida.entity.database;


import com.lolmeida.entity.BaseEntity;
import jakarta.persistence.*;
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
@Table(name = "tDimensoes") //, schema = "sql7509759")
public class Size extends BaseEntity {

    @Id
    @Column(name = "IdDimensoes")
    private String id;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "Guia")
    //@Column(name = "Guia")
    private Cargo cargo;

    @Column(name = "Vol")
    private int volume;

    @Column(name = "Comprimento")
    private double length;

    @Column(name = "Altura")
    private double height;

    @Column(name = "Largura")
    private double width;
}
