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
    private String id;


    private int volume;

    private double length;


    private double height;


    private double width;



    private String user;
}
