package com.source_user_authen.domain.user_role;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

public class TblUserRoleCreateRequest {

    @ApiModelProperty(value = "User id")
    @NotNull
    private Long userId;

    @ApiModelProperty(value = "Role id")
    @NotNull
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
        return "TblUserRoleCreateRequest [userId=" + userId + ", roleId=" + roleId + "]";
    }
}
