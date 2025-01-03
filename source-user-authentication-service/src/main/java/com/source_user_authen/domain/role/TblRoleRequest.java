package com.source_user_authen.domain.role;

import com.source_user_authen.utils.enummerate.CommonStatus;
import io.swagger.annotations.ApiModelProperty;

public class TblRoleRequest {
    @ApiModelProperty(value = "Tên role")
    private String name;
    @ApiModelProperty(value = "Trạng thái")
    private CommonStatus status;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CommonStatus getStatus() {
        return status;
    }

    public void setStatus(CommonStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "TblRoleRequest [name=" + name + ", status=" + status + "]";
    }
}

