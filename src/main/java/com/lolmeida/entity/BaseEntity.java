package com.lolmeida.entity;

import java.time.LocalDateTime;

import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Version;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import com.lolmeida.utils.Utils;

@Getter
@Setter
@Slf4j
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public abstract class BaseEntity {

    protected String updatedBy;

    protected boolean active;

    protected String note;

    protected String attachment;

    protected String createdBy;

    protected String image;

    protected String description;

    protected String comments;

    protected int counter;

    protected Long createdTime;

    protected Long updatedTime;

    protected LocalDateTime date;

    protected LocalDateTime createdAt;

    protected LocalDateTime updatedAt;


    @Version
    protected int version;

    @PrePersist
    public void prePersist() {
        this.date = Utils.getLocalDateTime();
        this.createdAt = Utils.getLocalDateTime();
        this.createdTime = Utils.getEpochTime();
        this.updatedAt = Utils.getLocalDateTime();
        this.updatedTime = Utils.getEpochTime();
        this.comments = String.format("Created by %s at %s", Utils.getCurrentUser(), this.createdAt);
    }

    @PreUpdate
    public void preUpdate() {
        this.updatedAt = Utils.getLocalDateTime();
        this.updatedTime = Utils.getEpochTime();
        this.comments = String.format("%s \nupdated by %s at %s", this.comments, Utils.getCurrentUser(), this.updatedAt);
    }
}
