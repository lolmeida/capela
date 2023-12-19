package com.lolmeida.entity;

import com.lolmeida.utils.Utils;
import jakarta.persistence.*;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;

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

    protected int Counter;

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
        this.comments = String.format("%s \nupdated by %s at %s",this.comments, Utils.getCurrentUser(), this.updatedAt);
    }
}
