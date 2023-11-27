package com.lolmeida.entity;

import io.quarkus.hibernate.orm.panache.Panache;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.UUID;

@Data
@Slf4j
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public abstract class BaseEntity {

    @Column(name = "DateTime")
    protected LocalDateTime createdAt;
    protected LocalDateTime updatedAt;
    //@Column(name = "UserEmail")
    protected String createdBy;
    //@Column(name = "ModificadoPor")
    protected String updatedBy;
    //@Column(name = "Activo")
    protected boolean deleted;
    //@Column(name = "Data")
    protected LocalDateTime date;
    //@Column(name = "Nota")
    protected String note;
    //@Column(name = "Anexo")
    protected String attachment;
    //@Column(name = "Utilizador")
    protected String user;
    //@Column(name = "Foto")
    protected String picture;
    //@Column(name = "Descriçao")
    protected String description;
    //@Column(name = "Observações")
    protected String comment;
    protected int Counter;


    @PrePersist
    void prePersist(){
        this.createdAt=LocalDateTime.now(ZoneId.of("UTC"));
        this.date=LocalDateTime.now(ZoneId.of("UTC"));
    }
    @PreUpdate
    void preUpdate(){
        this.updatedAt=LocalDateTime.now(ZoneId.of("UTC"));
    }
}
