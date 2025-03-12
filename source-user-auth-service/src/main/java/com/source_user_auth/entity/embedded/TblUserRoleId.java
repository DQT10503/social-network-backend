package com.source_user_auth.entity.embedded;

import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class TblUserRoleId implements Serializable {
    private static final long serialVersionUID = 944582590850212635L;
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "role_id")
    private Long roleId;

    public TblUserRoleId(Long userId, Long roleId) {
        this.userId = userId;
        this.roleId = roleId;
    }

    public TblUserRoleId() {}

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        TblUserRoleId entity = (TblUserRoleId) o;
        return Objects.equals(this.roleId, entity.roleId) &&
                Objects.equals(this.userId, entity.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roleId, userId);
    }

}