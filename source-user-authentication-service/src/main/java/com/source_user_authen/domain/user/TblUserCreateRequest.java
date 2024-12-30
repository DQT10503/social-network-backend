package com.source_user_authen.domain.user;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;

public class TblUserCreateRequest {
    @ApiModelProperty(value = "Họ và tên")
    @NotBlank
    private String fullName;
    @ApiModelProperty(value = "Địa chỉ email")
    @NotBlank
    private String email;
    @ApiModelProperty(value = "Mật khẩu")
    @NotBlank
    private String passwordHash;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    @Override
    public String toString() {
        return "TblUserCreateRequest [fullName=" + fullName + ", email=" + email + ", passwordHash=" + passwordHash + "]";
    }
}
