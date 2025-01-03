package com.source_user_authen.domain.user_role;

public class TblUserRoleResponse {
    private Long userId;
    private Long roleId;

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
    public String toString() {
        return "TblUserRoleResponse [userId=" + userId + ", roleId=" + roleId + "]";
    }
}
