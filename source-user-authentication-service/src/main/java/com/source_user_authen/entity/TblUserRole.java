package com.source_user_authen.entity;

import com.api.framework.security.BearerContextHolder;
import com.api.framework.utils.DateTimeUtils;
import com.source_user_authen.entity.embedded.TblUserRoleId;
import com.source_user_authen.utils.enummerate.CommonStatus;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;

@Entity
@Table(name = "tbl_user_role", schema = "public", indexes = {
        @Index(name = "tbl_user_role_user_id_key", columnList = "user_id", unique = true),
        @Index(name = "tbl_user_role_role_id_key", columnList = "role_id", unique = true)
})
public class TblUserRole implements Serializable {
    private static final long serialVersionUID = 76245920826689587L;
    @EmbeddedId
    private TblUserRoleId id;

    @Column(name = "created_at")
    private Instant createdAt;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "updated_at")
    private Instant updatedAt;

    @Column(name = "updated_by")
    private String updatedBy;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private CommonStatus status;

    public TblUserRoleId getId() {
        return id;
    }

    public void setId(TblUserRoleId id) {
        this.id = id;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Instant updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public CommonStatus getStatus() {
        return status;
    }

    public void setStatus(CommonStatus status) {
        this.status = status;
    }

    @PrePersist
    public void preInsert() {
        this.createdAt = DateTimeUtils.getCurrentTimeUTC();
        this.createdBy = BearerContextHolder.getContext().getMasterAccount();
    }

    @PreUpdate
    public void preUpdate() {
        this.updatedAt = DateTimeUtils.getCurrentTimeUTC();
        this.updatedBy = BearerContextHolder.getContext().getMasterAccount();
    }

    @Override
    public String toString() {
        return "TblUserRole [id=" + id + ", createdAt=" + createdAt + ", createdBy=" + createdBy + ", updatedAt=" + updatedAt + ", updatedBy=" + updatedBy + ", status=" + status + "]";
    }
}