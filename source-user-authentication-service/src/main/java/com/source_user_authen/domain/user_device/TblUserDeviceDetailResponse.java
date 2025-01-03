package com.source_user_authen.domain.user_device;

import com.api.framework.utils.converter.DateTimeJsonSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.source_user_authen.utils.enummerate.CommonStatus;

import java.time.Instant;

public class TblUserDeviceDetailResponse {
    private Long id;
    private Long userId;
    private String deviceType;
    @JsonSerialize(using = DateTimeJsonSerializer.class)
    private Instant lastLogin;
    private CommonStatus status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
        return "TblUserDeviceDetailResponse [id=" + id + ", userId=" + userId + ", deviceType=" + deviceType + ", lastLogin=" + lastLogin + ", status=" + status + "]";
    }
}
