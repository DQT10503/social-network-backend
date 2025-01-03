package com.source_user_authen.domain.role;

import com.source_user_authen.utils.enummerate.CommonStatus;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

public class TblRoleUpdateRequest extends TblRoleCreateRequest {
    @ApiModelProperty(value = "Id role")
    @NotNull
    private Long id;
    @ApiModelProperty(value = "Trạng thái")
    @NotNull
    private CommonStatus status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CommonStatus getStatus() {
        return status;
    }

    public void setStatus(CommonStatus status) {
        this.status = status;
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public void setName(String name) {
        super.setName(name);
    }

    @Override
    public String toString() {
        return "TblRoleUpdateRequest [id=" + id + ", name=" + getName() + ", status=" + status + "]";
    }
}
