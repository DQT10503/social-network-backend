package com.source_user_auth.entity;

import com.api.framework.security.BearerContextHolder;
import com.api.framework.utils.DateTimeUtils;
import com.source_user_auth.entity.embedded.TblUserRoleId;
import com.source_user_auth.utils.enummerate.AuthStatus;


import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;

@Entity
@Table(name = "tbl_user_role")
public class TblUserRole implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    private TblUserRoleId id;
    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private AuthStatus status;

    public TblUserRoleId getId() {
        return id;
    }

    public void setId(TblUserRoleId id) {
        this.id = id;
    }

    public AuthStatus getStatus() {
        return status;
    }

    public void setStatus(AuthStatus status) {
        this.status = status;
    }
}