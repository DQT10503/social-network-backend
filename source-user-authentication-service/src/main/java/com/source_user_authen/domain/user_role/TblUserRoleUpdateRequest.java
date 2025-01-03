package com.source_user_authen.domain.user_role;

import com.source_user_authen.utils.enummerate.CommonStatus;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

public class TblUserRoleUpdateRequest extends TblUserRoleCreateRequest{
    @ApiModelProperty(value = "Trạng thái")
    @NotNull
    private CommonStatus status;

    public CommonStatus getStatus() {
        return status;
    }

    public void setStatus(CommonStatus status) {
        this.status = status;
    }

    @Override
    public Long getUserId() {
        return super.getUserId();
    }

    @Override
    public void setUserId(Long userId) {
        super.setUserId(userId);
    }

    @Override
    public Long getRoleId() {
        return super.getRoleId();
    }

    @Override
    public void setRoleId(Long roleId) {
        super.setRoleId(roleId);
    }

    @Override
    public String toString() {
        return "TblUserRoleUpdateRequest [status=" + status + ", userId=" + getUserId() + ", roleId=" + getRoleId() + "]";
    }
}
