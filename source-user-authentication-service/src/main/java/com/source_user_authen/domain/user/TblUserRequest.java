package com.source_user_authen.domain.user;

import com.api.framework.utils.Annotations;
import com.source_user_authen.utils.enummerate.CommonStatus;
import io.swagger.annotations.ApiModelProperty;

public class TblUserRequest {
    @ApiModelProperty(value = "Họ và tên")
    @Annotations.Operator(value = "LIKE")
    private String fullName;
    @ApiModelProperty(value = "Địa chỉ email")
    private String email;
    @Annotations.Operator(value = "LIKE")
    private String userName;
    @ApiModelProperty(value = "Trạng thái")
    private CommonStatus status;

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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public CommonStatus getStatus() {
        return status;
    }

    public void setStatus(CommonStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "TblUserRequest [fullName=" + fullName + ", email=" + email + ", userName=" + userName + ", status=" + status + "]";
    }
}