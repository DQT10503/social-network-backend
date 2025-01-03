package com.source_user_authen.domain.user_device;

import com.api.framework.utils.Annotations.Operator;
import com.source_user_authen.utils.enummerate.CommonStatus;
import io.swagger.annotations.ApiModelProperty;

import java.time.Instant;

public class TblUserDeviceRequest {
    @ApiModelProperty(value = "Id người dùng")
    private Long userId;
    @ApiModelProperty(value = "Loại thiết bị")
    private String deviceType;
    @ApiModelProperty(value = "Lần đăng nhập cuối")
    private Instant lastLogin;
    @ApiModelProperty(value = "Trạng thái")
    private CommonStatus status;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    public Instant getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Instant lastLogin) {
        this.lastLogin = lastLogin;
    }

    public CommonStatus getStatus() {
        return status;
    }

    public void setStatus(CommonStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "TblUserDeviceRequest [userId=" + userId + ", deviceType=" + deviceType + ", lastLogin=" + lastLogin + ", status=" + status + "]";
    }
}
