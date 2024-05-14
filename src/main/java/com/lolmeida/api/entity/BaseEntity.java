package com.lolmeida.api.entity;


import java.time.LocalDateTime;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Version;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import com.lolmeida.api.Utils;


@Getter
@Setter
@Slf4j
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass

public abstract class BaseEntity {

    // Other auto generated fields
    protected LocalDateTime date;
    protected LocalDateTime createdAt;
    protected LocalDateTime updatedAt;
    protected String createdBy;
    protected String updatedBy;
    protected Long createdTime;
    protected Long updatedTime;
    protected boolean active;
    // Other fields
    protected String note;
    protected String attachment;
    protected String image;
    protected String description;
    protected String comments;
    protected int Counter;
    @Version
    protected int version;
    //@Column(name = "Activo", columnDefinition = "BOOLEAN DEFAULT TRUE",nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @PrePersist
    protected void onCreate() {
        this.createdTime = Utils.currentTime;
        this.createdAt = Utils.currentDateTime;
        this.createdBy = Utils.activeUser();
        this.date = Utils.currentDateTime;
        this.active = true;
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = Utils.currentDateTime;
        this.updatedTime = Utils.currentTime;
        this.updatedBy = Utils.activeUser();
    }
}
