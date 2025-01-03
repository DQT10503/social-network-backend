package com.source_user_authen.domain.role;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;

public class TblRoleCreateRequest {
    @ApiModelProperty(value = "Tên role")
    @NotBlank
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "TblRoleCreateRequest [name=" + name + "]";
    }
}
