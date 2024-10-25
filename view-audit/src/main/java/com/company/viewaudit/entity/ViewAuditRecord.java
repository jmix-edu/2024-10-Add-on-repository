package com.company.viewaudit.entity;

import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.metamodel.annotation.JmixEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.OffsetDateTime;
import java.util.UUID;

@JmixEntity
@Table(name = "VA_VIEW_AUDIT_RECORD")
@Entity(name = "va_ViewAuditRecord")
public class ViewAuditRecord {
    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    @Id
    private UUID id;

    @Column(name = "VIEW_ID")
    private String viewId;

    @Column(name = "USERNAME")
    private String username;

    @Column(name = "ACCESSING_TIMESTAMP")
    private OffsetDateTime accessingTimestamp;

    public OffsetDateTime getAccessingTimestamp() {
        return accessingTimestamp;
    }

    public void setAccessingTimestamp(OffsetDateTime accessingTimestamp) {
        this.accessingTimestamp = accessingTimestamp;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getViewId() {
        return viewId;
    }

    public void setViewId(String viewId) {
        this.viewId = viewId;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}