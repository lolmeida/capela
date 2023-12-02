package com.lolmeida.entity;

import com.lolmeida.Utils;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;

@Data
@Slf4j
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public abstract class BaseEntity {
    protected String UserEmail;
    protected String ModificadoPor;
    protected boolean Activo;
    protected String Nota;
    protected String Anexo;
    protected String Utilizador;
    protected String Foto;
    protected String Descricao;
    protected String Observacoes;

    @Column(columnDefinition = "INT DEFAULT 0")
    protected int Counter;
    protected Long createdTime;
    protected Long updatedTime;

    @Version
    protected Integer version;

    @Column(name = "Data", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    protected LocalDateTime Data;
    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    protected LocalDateTime createdAt;
    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    protected LocalDateTime updatedAt;


    @PrePersist
    protected void onCreate() {
        this.createdTime = Utils.currentTime;
        this.createdAt = Utils.currentDateTime;
        this.Data = Utils.currentDateTime;
        this.Utilizador = Utils.activeUser();
        this.UserEmail = Utils.activeUser();
        this.Activo = true;
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = Utils.currentDateTime;
        this.updatedTime = Utils.currentTime;
        this.ModificadoPor = Utils.activeUser();
    }
}
